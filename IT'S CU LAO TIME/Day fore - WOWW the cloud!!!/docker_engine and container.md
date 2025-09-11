## **I. Containerization**
### 1. what is containerization
- 
### 2. how does it work?
## **II. Docker engine**
1. What is docker engine :>
    Docker engine is for building and containerizing our applications
    act like client-server application, with:
        - a server with a long-running daemon process
        - APIs which specify interface with that programs can use to talk to and instruct the docker daemon
2. what is docker:
- open source containerization platform by which you can pack your application and all its dependencies into a standardized unit called a containers.
- container are light weight and make them portable, and they are isolated, which helps us not to worried about, can also deploy any application on any devices.
3. why docker is so popular>
- I have no idea instead of 3 main reasons:
    - portability
    - reproductivity
    - efficiency

4. key components for docker:
a docker engine: is a core parts of a docker, that handles the creations and management of containers
- architecture:
    layer 1: docker client: docker command (CLI)
    layer 2: docker daemon: control containers
    layer 3:- containered: life cycle: 
            - images and containers:  
                - images: un-change able blueprints, which is created from the DockerFile.
    layer 4: docker registries: place where docker image lives and get shared.  
b. docker image: is a read-only template that used to create the containers, containing the application code and dependencies

c. docker hub:
- repository service and it is store, download and manage docker image
- mainly devops team use docker hub

d DockerFile
- DockerFile uses DSL (Domain special language) and contain instructions for generating a docker image. 
- DockerFile will define the processes to quickly produce an image. while creating your application, you should create a DockerFile in order since the docker daemon runs all of the instructions from top to bottom.
- DockerFile is the source of the image. 

e. Docker Command:
docker run: launching the containers from images
docker pull: pull docker image from a Registery like docker hub to the devices 
docker ps: display the running containers along with their important information like container ID or something
docker stop: stop running containers or shutting down the services that containers is activating
docker start: the opposite with the docker stop
docker login: helps to login in to the registry and activate repository 

f. Docker Daemon: this is a background service that manage docker containers on a system.

like, [DockerFile] --Build--> [docker image] --Run--> [docker containers]

5. docker architecture
- client-server concept.
client
    (
        DockerBuild;
        DockerPull;
        DockerRun;
    )

DockerHost
    (
        dockerdaemon:
        (
            containers:
                container1; 
                container2;
        )
        (
            image:
                operation1;
                operation2;
        )
    )

Registery
    (
        docker
            Operations:
    ) 