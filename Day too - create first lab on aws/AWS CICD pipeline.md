I. Ideate
- Deploy application in ec2 with code Pipeline

1. introduction:

on the developer site:
step 1: dev code and commit the code to github
step 2: github triggers the aws CodePipeline
step 3: CodePipeline triggers the Build Project
step 4: AWS CodeBuild builds the image and push it to docker Hub
step 5: AWS CodeDeploy fetch image and deploy it on EC2 server
step 6: now your application could run on an EC2 server

On the user site:
step 1: users access app with public ip (which is pointed to the ec2 ) 

2. AWS Services

a. AWS CodeBuild:

- it is a fully managed continuous integration and continuous delivery (CI/CD) service provided by AWS.
- it allows developers to automate the building - testing - and development of their code in a scalable and customizable environment.
- CodeBuild eliminates the need to setup, maintain, and scale build servers, enabling developers to focus more on writing code and less on managing infrastructure


- key features:
    + **fully managed services**: AWS CodeBuild is a fully managed service, meaning AWS takes care of infrastructure provisioning, scaling, and maintenance, allowing developers to focus on their code.

    + **Flexible environment**: CodeBuild supports various programming languages, build tools and OS, providing a flexible environment for building, testing and developing code.

    + **integration with other AWS Services**: CodeBuild seamlessly integrates with other aws services such as CodePipeline, CodeCommit, and Amazon S3, allowing for a fully automated CICD pipeline

    + **security and compliance**: providing built-in security features => fine-grained access control

b. AWS CodeDeploy:

- Is a service provided by AWS that automates code deployments to any instance, including amazon ec2 instances and instances running on-premisses. it allows devs to deploy applications in a consistent and reliable manner across different environments

- key features:
    + easyu 