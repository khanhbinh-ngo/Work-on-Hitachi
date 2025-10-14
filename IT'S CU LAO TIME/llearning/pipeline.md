// This is the line code to define service on aws, which is set up at a defined url
// we also define ecs service map: 
    - the image which service would use, stored on ecr
    - the place where image/container would work after they were built
    - the artifact name used to built in (the output of the build-image-process)
    - the container and the cluster where this image belong (where image stored at ecr is push and work on ecs)
    - service name: name of the ecs service that manage container directly

def ECSServiceMap = [
    "CURSUS-MDMS-ECS-MDM-L-VEE": [

        // the image is stand for where it stored on aws, 

        // "cursus-mdms/hafedc-mdm-shjsu-low-m30-vee", : mean on ecr has one repository named cursus-mds which inluding the ".../hafedc-mdm-shjsu-low-m30-vee" image

        // workingdir: is the place to setting up such like build, run or deploy, this is the directory inside image or container


        // artifactid: output name, the place where build process is finish. 

        // cluster: name of the cluster belongs to ecs services on aws. we could re-define or rename it when the cluster has changed. also, the place where we deploy after finish build image 

        // servicename: name of the service which manage task/the container.

        "image": "cursus-mdms/hafedc-mdm-shjsu-low-m30-vee", 
        "workingdir": "package/hafedc/mdm/cursus-mdms-package-hafedc-mdm-shjsu-low-m30-vee",
        "artifactid": "cursus-mdms-package-hafedc-mdm-shjsu-low-m30-vee",
        "cluster": "CURSUS-MDMS-ECS-MDM-L-VEE",
        "container": "ECS-Ctr-MDM-L-VEE-APP",
        "servicename": "ECS-Task-MDM-L-VEE-APP-service-506920n3" 
    ],
    "CURSUS-MDMS-ECS-EDC": [
        "image": "cursus-mdms/hafedc-edc",
        "workingdir": "package/hafedc/edc",
        "artifactid": "cursus-mdms-package-hafedc-edc",
        "cluster": "CURSUS-MDMS-ECS-EDC",
        "container": "ECS-Ctr-EDC-APP",
        "servicename": "ECS-Task-EDC-APP-SV"
    ],
    "CURSUS-MDMS-ECS-MDM-L-EVENT-REAL": [
        "image": "cursus-mdms/hafedc-mdm-event-low-real",
        "workingdir": "package/hafedc/mdm/cursus-mdms-package-hafedc-mdm-event-low-real",
        "artifactid": "cursus-mdms-package-hafedc-mdm-event-low-real",
        "cluster": "CURSUS-MDMS-ECS-MDM-L-EVENT-REAL",
        "container": "ECS-Ctr-MDM-L-EVENT-REAL-APP",
        "servicename": "ECS-Task-MDM-L-EVENT-REAL-APP-SV"
    ],
    "CURSUS-MDMS-ECS-MDM-L-M30-REAL": [
        "image": "cursus-mdms/hafedc-mdm-shjsu-low-m30-real",
        "workingdir": "package/hafedc/mdm/cursus-mdms-package-hafedc-mdm-shjsu-low-m30-real",
        "artifactid": "cursus-mdms-package-hafedc-mdm-shjsu-low-m30-real",
        "cluster": "CURSUS-MDMS-ECS-MDM-L-M30-REAL",
        "container": "ECS-Ctr-EDC-APP",
        "servicename": "ECS-Task-MDM-L-M30-REAL-APP-SV"
    ],
    "CURSUS-MDMS-ECS-MDM-L-M30-PAST": [
        "image": "cursus-mdms/hafedc-mdm-shjsu-low-m30-past",
        "workingdir": "package/hafedc/mdm/cursus-mdms-package-hafedc-mdm-shjsu-low-m30-past",
        "artifactid": "cursus-mdms-package-hafedc-mdm-shjsu-low-m30-past",
        "cluster": "CURSUS-MDMS-ECS-MDM-L-M30-PAST",
        "container": "ECS-Ctr-MDM-L-M30-PAST-APP",
        "servicename": "ECS-Task-MDM-L-M30-PAST-APP-service-lqchfyxw"
    ]
]


// this is the way we define how 
def ECSServiceKeysAsString = ECSServiceMap.keySet().collect { "\"$it\"" }.join(", ")

properties([
    parameters([
        string(name: 'branchName', defaultValue: 'develop_phase2_vee', description: 'Git branch to build'),
        choice(name: 'awsRegion', choices: ['ap-southeast-1', 'ap-southeast-7'], description: 'AWS region for ECS Service deployment'),
        [
            $class: 'CascadeChoiceParameter',
            choiceType: 'PT_CHECKBOX',
            name: 'ECSServices',
            description: 'Select one or more ECSService',
            script: [
                $class: 'GroovyScript',
                script: [classpath: [], sandbox: true, script: "return [${ECSServiceKeysAsString}]"],
                fallbackScript: [classpath: [], sandbox: true, script: 'return []']
            ]
        ]
    ])
])


pipeline {
    agent any
    environment {
        DOCKER_REGISTRY = '230150030283.dkr.ecr.${awsRegion}.amazonaws.com'
        DONADONA_DISTRIBUTION_PATH = 'libs/com/hitachi/sawara/donadona/donadona-distribution/4.2.0/donadona-distribution-4.2.0.zip'
        }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: params.branchName]],
                    userRemoteConfigs: [[
                        url: 'https://git.hv-vn.com/ict/mdms-joint-business.git',
                        credentialsId: '3e410c60-eae2-49a9-b3d4-b18bd6ee6632'
                    ]]
                ])
            }
        }

        stage('Copy libs folder to .m2 repo') {
            steps {
                sh "cp -r ./cursus-mdms/libs/* ~/.m2/repository/com/hitachi/"
            }
        }

        stage('Package jar file') {
            steps {
                dir('cursus-mdms') {
                    script {
                        def services = params.ECSServices.split(',').collect { it.trim() }
                        def module = services.collect { svc ->
                            def config = ECSServiceMap[svc]
                            if (!config) {
                                error "Service '${svc}' is not exist trong ECSServiceMap!"
                            }
                            return ":${config.artifactid}"
                        }
                        def modulesToBuild = module.join(',')
                        echo "🔨 Building Maven modules: ${modulesToBuild}"
                        
                        sh "mvn package -pl ${modulesToBuild} -am -DskipTests"
                    }
                }
            }
        }
        
        
        stage('Build ECS Services') {
            steps {
                withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws_cred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
                    script {
                        sh """
                            aws ecr get-login-password --region ${params.awsRegion} | \
                                docker login --username AWS --password-stdin ${env.DOCKER_REGISTRY}
                        """
                        def services = params.ECSServices.split(',').collect { it.trim() }

                        for (svc in services) {
                            def config = ECSServiceMap[svc]
                            def imageName = config.image
                            def workingDir = config.workingdir
                            def artifactId = config.artifactid
                            def cluster = config.cluster
                            def container = config.container
                            def servicename = config.servicename
                            def fullImageName = "${env.DOCKER_REGISTRY}/${imageName}:latest"

                            echo "🚀 Deploying ${svc} with image ${fullImageName}"

                            sh """
                                cd cursus-mdms
                                docker build \
                                --build-arg ARTIFACT_ID=${artifactId}-0.0.1-SNAPSHOT \
                                --build-arg WORKINGDIR=${workingDir} \
                                --build-arg DONADONA_DISTRIBUTION_PATH=${DONADONA_DISTRIBUTION_PATH} \
                                -t ${fullImageName} .
                                docker push ${fullImageName}
                                
                            """
                        }
                    }
                }
            }
        }

        stage('Get Current Task Definition') {
            steps {
                withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws_cred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
                    script {
                        sh """
                            aws ecr get-login-password --region ${params.awsRegion} | \
                                docker login --username AWS --password-stdin ${env.DOCKER_REGISTRY}
                        """
                        def services = params.ECSServices.split(',').collect { it.trim() }

                        for (svc in services) {
                            def config = ECSServiceMap[svc]
                            def imageName = config.image
                            def workingDir = config.workingdir
                            def artifactId = config.artifactid
                            def cluster = config.cluster
                            def container = config.container
                            def servicename = config.servicename
                            def fullImageName = "${env.DOCKER_REGISTRY}/${imageName}:latest"

                            def currentTaskDef = sh(
                                script: """
                                    aws ecs describe-services \
                                      --cluster $cluster \
                                      --services $servicename \
                                      --region ${params.awsRegion} \
                                      --query "services[0].taskDefinition" \
                                      --output text
                                """,
                                returnStdout: true
                            ).trim()
                            
                            def taskDefJson = sh(
                                script: """
                                    aws ecs describe-task-definition \
                                      --task-definition ${currentTaskDef} \
                                      --region ${params.awsRegion} \
                                      --query "taskDefinition"
                                """,
                                returnStdout: true
                            ).trim()

                            writeFile file: 'task-def.json', text: taskDefJson
                            
                            sh """
                                jq --arg IMAGE "${fullImageName}" \
                                   --arg CONTAINER "${container}" \
                                   'del(.status, .revision, .taskDefinitionArn, .requiresAttributes, .compatibilities, .registeredAt, .registeredBy) |
                                    .containerDefinitions |= map(if .name == \$CONTAINER then .image = \$IMAGE else . end)' \
                                   task-def.json > new-task-def-${svc}.json
                            """
                            
                        }
                    }
                }
            }
        }
        
        stage('Deploy ECS Service') {
            steps {
                withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws_cred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
                    script {
                        sh """
                            aws ecr get-login-password --region ${params.awsRegion} | \
                                docker login --username AWS --password-stdin ${env.DOCKER_REGISTRY}
                        """
                        def services = params.ECSServices.split(',').collect { it.trim() }

                        for (svc in services) {
                            def config = ECSServiceMap[svc]
                            def imageName = config.image
                            def workingDir = config.workingdir
                            def artifactId = config.artifactid
                            def cluster = config.cluster
                            def container = config.container
                            def servicename = config.servicename
                            def fullImageName = "${env.DOCKER_REGISTRY}/${imageName}:latest"

                            def newTaskDefArn = sh(
                                script: """
                                    aws ecs register-task-definition \
                                      --cli-input-json file://new-task-def-${svc}.json \
                                      --region ${params.awsRegion} \
                                      --query 'taskDefinition.taskDefinitionArn' \
                                      --output text
                                """,
                                returnStdout: true
                            ).trim()

                            env.NEW_TASK_DEF_ARN = newTaskDefArn
                            sh """
                                aws ecs update-service \
                                  --cluster ${cluster} \
                                  --service ${servicename} \
                                  --task-definition ${NEW_TASK_DEF_ARN} \
                                  --region ${params.awsRegion} \
                                  --force-new-deployment
                                  
                                docker rmi -f ${fullImageName}
                            """

                        }
                    }
                }
            }
        }
        
    }
}
