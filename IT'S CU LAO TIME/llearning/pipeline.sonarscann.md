pipeline {
    agent any
	
	environment {
			SONARQUBE_ENV = 'MySonarQubeServer'
			NVD_API_KEY = credentials('NVD_API_KEY')
		}

    stages{
		
        stage('Checkout SCM') {
            steps{
                checkout scmGit(branches: [[name: 'develop_phase2_vee']], extensions: [], userRemoteConfigs: [[credentialsId: '3e410c60-eae2-49a9-b3d4-b18bd6ee6632', url: 'https://git.hv-vn.com/ict/mdms-joint-business.git']])
            }
        }

        stage('Package jar file'){
            steps {
                sh """
					cp -rf ./cursus-mdms/libs/* ~/.m2/repository/com/hitachi/
                    cd cursus-mdms
                    mvn -T 4 install
                """
            }
        }
		
		stage('Checkstyle'){
            steps {
                sh """
                    cd cursus-mdms
                    mvn -T 4 install checkstyle:checkstyle -Dmaven.test.failure.ignore=true
                """
            }
        }
		
		stage('dependencyCheck') {
			steps {
				sh """
                    cd cursus-mdms
						mvn org.owasp:dependency-check-maven:check \
											  -Dnvd.api.key=$NVD_API_KEY \
											  -Dformat=XML \
											  -DoutputDirectory=target

                """
            }
        }
        
        stage('Package images '){
            steps {
                sh """
                    cd cursus-mdms
                    docker compose build
                """
            }
        }
		
        stage('Trivy Vulnerability Scanner') {
           steps {
               // Perform vulnerability scans with Trivy
			   
               sh '''
					
					export TRIVY_CACHE_DIR=.trivy-cache
					export TRIVY_INSECURE=true
					export http_proxy=http://donkey.cybersoft.vn:8080
					export https_proxy=http://donkey.cybersoft.vn:8080
					for image in $(docker images --format '{{.Repository}}:{{.Tag}}' | grep 'hafedc'); do
						pure_image=$(basename "${image%%:*}")
						trivy image "$image" --db-repository ghcr.io/aquasecurity/trivy-db \
							--severity LOW,MEDIUM,HIGH,CRITICAL \
							--exit-code 0 \
							--quiet \
							--timeout 30m \
							--format json --output "trivy-${pure_image}.json" 
					   
						trivy convert --format template \
						   --template "/usr/local/share/trivy/templates/html.tpl" \
						   --output trivy-${pure_image}.html "trivy-${pure_image}.json"
						   
						trivy convert --format template \
						   --template "/usr/local/share/trivy/templates/junit.tpl" \
						   --output trivy-${pure_image}.xml "trivy-${pure_image}.json"
					done

               '''
           }
		}
		stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
					sh '''
						cd cursus-mdms
                    	mvn -T 4 sonar:sonar \
							-Dsonar.login=$SONAR_TOKEN \
							-Dsonar.java.checkstyle.reportPaths=**/checkstyle-result.xml
							-Dsonar.dependencyCheck.reportPath=target/dependency-check-report.xml
							--Dsonar.externalIssuesReportPath=**/trivy-*.xml
					'''
				}
            }
        }

        
    }
        
	post {
        always {
			dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
			unit allowEmptyResults: true, testResults: 'trivy-*.xml'
			publishHTML([
			   allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true,
			   reportDir: '.', reportFiles: 'trivy-*.html',
			   reportName: 'Vulnerabilities'
			])
			archiveArtifacts artifacts: 'target/dependency-check-report.xml', fingerprint: true
        }
    }
		
        
       
   
}


explaination:
