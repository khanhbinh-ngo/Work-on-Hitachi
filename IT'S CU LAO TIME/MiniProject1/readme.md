This mini project would setting up a jenkins pipeline using jenkins filE, the continuous deployment would be done by github webhook
(actually I could use other thing to manage and build this project later.)

Like the most of any project that represent about the cicd pipeline, let's get started on how many component that the project needed

1 . deploying a node js application on amazon eks
a.  the component:
- AMAZON ELASTIC COMPUTE - CLOUD AMAZON ec2
- jenkins
- github
- kubernetes

b. the workflow:
- when devs commit code from local to the github repository
- jenkins checkout github repository 
- then build docker image
- then push docker image to docker hub
- then deploy the application on eks (ec2) through some kubernetes settings

c. step by step
- we will be setting up a jenkins pipeline using jenkins file (*I would use my pc to host the jenkins*)
- then the continuous deployment would be done by github webhook. jenkins github webhook automates the build and deployment of applications when any commit is done to the source code

    1. step 1: create and setup your pc
    2. step 2: install java to the wsl (i would use ubuntu as a note and play with Jenkins on)

    sudo apt install openjdk-17-jre-headless
    java -version

    3. step 3: install and set up jenkins

    sudo apt remove jenkins -y
    wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null
    echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
    sudo apt update
    sudo apt install jenkins -y
    jenkins -version
    sudo systemctl enable jenkins
    sudo systemctl start jenkins
    sudo systemctl status jenkins
    hostname -I > [wsl ip address]

    // at the browser, pl;ugin: http://[wsl ip address]:8080 (just because these jenkins run on port 8080)

    // at the jenkins terminal, add
    sudo cat /var/lib/jenkins/secrets/initialAdminPassword

    then we can continuously set up name, admin name and admin password (also full name and email)
    
    4. step 4: update visudo and assign administrative privileges to jenkins user
    
    - now let's add jenkins user as an administrator and also add NOPASSWD so that during the pipeline run it will not ask for root password    sudo vim /etc/sudoers
        jenkins ALL=(ALL) NOPASSWD: ALL
    - after adding the line save and quit the file, we can user jenkins as root user and for that run the following command:
    
    sudo su -jenkins
    ** bignote **: after the line, all command lines bellow are run as a jenkins user and not an ubuntu user

    5. step 5: install docker
    sudo apt install docker.io
    docker --version
    docker ps
    sudo usermod -aG docker jenkins
    sudo docker ps
    sudo reboot

    6. step 6: install and setup aws cli

    sudo apt install awscli
    curl "https://awscli.amazonaws.comn/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
    unzip awscliv2.zip
    sudo ./aws/install --update

    random code zip AKIA4ZLZKMUC4RRTGSIC
    random code zip sec  bgF6e49049tO+r2sxx1MhwuCaPB/ZNU+wy15/G8/
    - then we can actually config the aws cli so that we can acuthenticate and communicate with the aws environment

    aws configure

    after login, and create multiple thing on your aws account, why dont we just ad on?


    7. step 7: install and setup kubectl(which is absolutely usable and deployable on my wsl)
    curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"

    chmod +x kubectl

    sudo mv kubectl /usr/local/bin/

    kubectl version --client

    8. step 8: create and eks cluster using eksctl
    curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
    sudo mv /tmp/eksctl /usr/local/bin
    eksctl version

    9. step 9: add docker and github credentials on jenkins\
    10. step 10: build/deploy/test cicd pipeline
    11. step 11: setup jenkins - github webhook
    12. step 12: clean up (have no idea)

