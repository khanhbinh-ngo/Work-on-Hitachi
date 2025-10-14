## I. Concepts: AWS CERTIFIED CLOUD PRACTITIONER
1. introduction

2. storage services

3. compute services

4. database services

5. compute and networking services

6. management services

7. analytics and machine learning services

8. security, identity, and compliance services

9. intro developer, media, mobile, migration, business and iot.

10. demonstration: aws workspace 

11. command line interface (cli)

12. aws cloud shell

13. aws cloud9 ide 

14. business for aws

15. aws architecture and compliance (thiết kế cùng thiết bị)

    1. what is a good architecture which including some framework and some sample. such a thing, we enter to the aws architecture center. providing us a large amount of sample aws architectures
        - aws architecture center: we could complex and detailed architecture, we could use that as a big libraries for you to launch your own architectures
        - for example, this is we could use those sample for your architectures later.
        - well, IaS and more than that. I could see they use cloudformation yml file to describe the architecture, which have multiple purposes, like setting up the vpc, scurity the github...
        - take times and cause lots of bugs if we do it manually OR using architecture as code (IaC) 
        - so what is (or are) the big problem*(s)
            - server and database is not centerization, then have change to drop one version of the instance which have different version of data, compared to other insances.
            - load balancer that which is the diffent and control the centering which i good.
            - the architecture is learnt by you when you need to design a new one.
            - setting up the starting point to defined as a start, standard for your architecture version.
        

    2. discussion about difficult case: which is the well architected and the filve pillars
        - five pillars:
            - operational excellence (xuat sac trong hoat dong)
                - make sure our archi have processes design, inmplemented as code like loud formation and using version control to reduce waste of money=
            - security (bao mat)
                - deploy cloudtrails to track user activity and api usage
                - provide them just enough permission to do their work
                - create a vpc architecture with multiple layers of security, 
            - fault tolerance (chong loi)
            - reliability (do do tin cay)
                - highly ava9lable archi which is could response and could use longterm
            - performance efficiency (hieu suat)
                - make sure use 100% current resources (no need to waste money)
            - cost optimization (toi uu chi phi)
                - choose right type of resources
                - use spot instances, reserved instances, saving plans
    3. we could visit well-architected tools
    - how it works? helps you to defile the best aws architecture
    - define the best practices for your architecture
    - review your workloads against best practices and get advice for making improvements and then save those work as the response point, we could roll back to the point 
    - best design and marketing tool as well
    - how to learn more:
        - aws well-architected website and comes to well architected lense (which is re defile the machine learning lifecycle)
        - there we could learn how we could see the excellent thing  to archieve that goals.
    - best practices:
        - use multiple availability zones
        - enable versioning for s3 buckets
        - use cloudfront to deliver content globally with low latency
        - use managed services to reduce the operational overhead
        - automate the entire architecture using IaC (cloudformation, terraform...)
        - monitor application and infrastructure performance using cloudwatch and x-ray
        - implement a robust incident response process
        - use tagging to organize your aws resources for cost tracking and management
        - regularly review your architecture using the well-architected tool
    - through that, we could learn more and do more with aws architecture framework
    - how to create:
        - aws complance: https://aws.amazon.com/compliance/ the thing we talk about the shared responsibility and how to do with that.
        - lot's of informations, secwrets and you could read to understand that shit.
        - AWS Artifact: https://aws.amazon.com/artifact/ — AWS Artifact is a central resource for compliance-related information, including reports and agreements.
        (aha, the dokumentation is such a full shit - which is so fucking large content)


16. architecture discussion and lab preparation

    - hosting the basic website with workpress (somehow)
    - provide some basic (most common) and use to test the thing.
    - provide security group for so on. (not include on free tier.)



17. purchasing domain name with route53

18. creating a s3 bucket and hosting a static website

19. creating a ssl certificate with aws certificate manager

20. creating a cloudfront distribution

21. routing traffic with route53

22. IAM foundations

    1. Very important note: 
        - this sections is completely 1 hours to understand
        - this contains 3 things: IAM - Organizations - CloudTrail
    2. Shared responsibility model
        - this have 2 side: customers and aws. (we are as a customers ) have respon:
            - data, create, use and create what your organization works and shared in the clouds.
            - here I have something to read through the test
        - the model: 
            - but there is have something more complex: infrastructure sevices:
                - we could use infrastructure as a services
                - and control aws ebs, auto scaling 
        - container services:
            - aws provides a managed services, we could use that to custom our own container services
        - managed services:
            - high level datrabase, that aws manages the underline sercies components or the operating system on which they resize (a lot more control from the aws side, you just need to setup and your aws would do it for you) 
    - what is iam?
        - acreate and manage identities and grant permissions
        -features:  
            - shared access to your aws account
            - granular permissions (quyen chu tiet) - để tránh cho oogn nào táy máy làm hỏng cả một đại sự thì việc đưa ra được quyền chi tiêt tối đa xem ra là cực kì có ích 
            - secure acecss to ắ resources for applications that run on ec2
            - identity federation to grant permissions for users outside of aws
            - pci dss some how
            - acces log auditing using cloud trail
            - eventually consistent: sự nhất quán (globally)
            - free to use (unlimited)$

    3. users, groups, roles.
        - users: 
            - represent the perseon or service accessing your acocout
                - name 
                - credenticials
            - users are identifyied by
                - freneld name
                - unique identasdf ver
            - credentials can be associated to a use:
                - console paassowrd
                - acess keys (max 2)
            - never use root user to access resoucess unless absolutely essential. create admin users with required permission, always enable multi-factor authentication of the root user
            - user password policy: am harmless workstation, just chill
            - sign in url: like theory that sign-in page usrl that have somthing https://your_alias and something. 
        - group:
            - collection of iam user
                - assume the permission of the grups
                - groups can only contain users, cannot be nested. 
        - roles:
            - define permissions that can be assumed by users or resources.
                - like allows ec2 instances to acces other aws resources 
                - grant acces to your resources to users in another aws account.
                - can be used to allow users to temporarily assume a role with least privilcesgesa somthing
    4. aws organisations
        - allow multiple aws acconunt used by an organisations to be part of a n organisational unti (ou)
        - service control policies (SPCs) allow the whitelisting or blacklisting of services within an ou
        - a blacklisted service will not be available even if the iam user or gr allows it
        - benefits
            control access to aws servcices
            - automate aws acoount createion with api 

            - consolidate the billing across multiple aws account
        - how does it works?

    5. iam policies
        - policy to define what access or group something 
        - by default, users cannot access anything in your accont
        - grant permissions through policies that define the effect, afctions, resasjdfalsjfl and somthing
            such like
                {"version": "date"
                "statement":
                "somethign bassic"
                "resource":"someresources that are soemthing
                "}
        - amazon resourefce name: (ARNs)
            - the access policy language requires you to specify the resource or resources have some name like:
                [arn:aws:iam::account::resource (note region missing)]

            - that user-based v resource based poolicies
                - iam policies are attacched to a user group or somthing

    6. identity federation
    - an iam role can be used to specfiy permissions for externamllyu ide tnfasdf 
    (federated user)
    - max 5000 iam uers per account, identity federation enables unlimited temporary credentials
    - identified by oyour organizations or a thrid opartuy dientify provider
    - amazon cognito developer authenticated idenn tnitesf 
    - or we could use somethinrd partu to provide other providers.
    - could create identity or somtehing application. 
    7. aws cloud trail
        - very important service.
        - aws management console, sdk and cli all use the aws api to communicate to awws servcies
        - this can log calls to aws sercices from the aws api
        - logs are stored in a bucket and can be analysed. (prevent more )
        - sns topic can alert security issues. 

    8. so, let's have some fun role to understand this iam
        - look away your aws account root user access keys
        - create individual iam users
        - use groups to assign permissions to iam users
        - use aws defined policies to assign permissions whenever possible
        - grant least privilege
        - use access levels to review iam permissions (list, read, write, or permissions management)
        - configure a strong passowrd policy for your users
        - enable multi-factor authentication ofr priviledgse uses
        - delegete by usgin roles instead of sharing credenticals
        - use roles for applications that run on amazon ec2 instances 
        - rotate cretendicaalsdf regularlly 
            - monitor activity in your aws account. 
        - get familiar with iam is a hard, but let's have some look. 
            - delivering bulletproof html5 website with aws? hell yeah that is a good one.


23. multi factor authentication (MFA)
    - what is mfa? hehe, I don't know. 
    - How to do that thing> ? let's have authy mobile app. 
24. hand on: trusted advisor.
- may be, this trick is only for company things like  

25. Elastic compute Cloud (EC2)
    1. purchasing options and instance types
        - on demand instances 
            pay, by the second wiht no up-front or terminationg cost
        - spot instances
            - requeest unused ec2 instances, wihch can lower uyour cost significantly.
            - generally chealpasdfst option although not always
            - maximum prices (hell yeahhhh)
        - ec2 purchasing options
            - reverssed instances
            - scheduled instances
            - on demand capacity reservations
            - dedicated instances
            - dedicated hosts
        - ec2 saving plans (I have none to know that, but I would probably learn that on other time)

        - ec2 instance types: based on which you want to use cloud calculating power

            - general purpose
                - small and midsize database, data processing tasks that require additional memory, caching fleets and for running backed server for sap, microsoft sharepoint, cluster computing nad other enterprise applications (t2, m3 and m4)
            - compute optimiuuzed:
                - high performance front end fleets, webservers batch processing, some high-end application with optimize for compute task
            - memory optimized:
                - high performance databse, like distributed memory caches, in-memory analytics, and so on
            - gpu/accelerated computing
            - storage optimized (some how we could use nosql, database like cassandra or mongodb), just optimizting for storage task
            - and what about linux or windows operating systme? notgood but have more responsibility just for surel
            - ec2 bare metal instances: non-vm environments
                - os running directly on that hardware
                - suitable for
                    - applications that benefit from deep performances analysis tool 
                    - some how leagacy workloads not supopoered in virtual environment
                    - licensing- restricted tier 1 business critical aoplications
                    have more thing like i3 and metal somehow
            - understanding t2 and t3 burstable perforlamsdf ce
                - like, they have more and more perfomancee bare pwer to burst.
                - unlimited mode provides high cpu at a flat additional razte of 5% pervcpos hors for as long as needed.
                - if yoru instance does not maintain a positive cpu fcredit balance for bursting consider upgradding to larger instance
            - graviton instance types (like, an grtaviton = custom chip designed by aws and used by arm neoverse architecture (which is not familiar with intel x86))
                - they like bult specifically for
                    - lower cost per compute
                    - lower power consumption
                    - high efficiency for modern workloads (microservices, containers, java)
                - graviton ver 2 processors provide up to 40% better p/p over compaable current generatiion x86 based instances
                - perfect for scale out applications taht can run on small cores (I have no idea waht is that or how to understand the words "applications that can run on small cores")
            - ec2 fleet:
                - launch a fleet, or a grup, of instances
                - like, theyt have unlimited number of inscances types per ec2 fleets.
                some how like that
        - so the amazon machine images (AMI)
            - provides the information required to launch an instances 
                - a template for the root volume for the instances (LIKE OS, applications serv er, appkuicatosnfasdf)
                - launch permissions that control which aws accounts can use the ami to lauhch iunstances
                - this is a block devieces mapping that specifies the vomumes to attach to the siuntacnes when it launcched
        - ec2 instance states
            - there are 4 states of a ec2
                - start
                - stop (ebs backed only)
                    - instance is shutdown with no instance chares
                    - still charged for ebs volumes
                    - minimum of 1 minunets charsf on restart
                - stop/hibernate (ebs backed only)
                    - suspend to disk
                    - saves ram to ebs
                - reboot
                    - operating system reboot 
                - terminate
            - we can use ami to launch and somehow. there are some thing that we could use (have a life circle of these ec2)
    2. instance lifecycle
        - ami - pending <----------------
                    |                   |
    rebooting - running -> stopping -> stopped
                    |
                shutting down
                    |
                terminated

    like so, and then when we stopped the instace wie could terminated it or pending it. eazii

    3. storage options
        - ec2 storage options
            that here we have some common sence to understand, but jst save directly to the ec2, nor other outer storage services like s3

            - elastic bloc storage (ebs)
                - most common
                - ebs volumes attacheed at instance launch are deleted when instances terminated
                - ebs volumes attached to a running instance are not deleted when instace is terminated but are detached with data intact

            - instance store
                - pyysically attached to teh host server
                - data would lost when:
                    - underlying drive failes
                    - instance interminated
            - to sum up, this is just a very very temporary solutionasdf
            
            ebs storage options
                - general purpose ssd
                - provisiioned iops ssd
                - cold hdd
                    - lowest cost per gigabyte
    4. remote access
        - ec2 linux server
            - well, we could use secure shell (SSH) to connect wiht ec2
            - your windows requires ssh or bash client 
            - requyires PEM key file (somehow, ez)
        - ec2 windws server
            - use remote desktop protocol 
            - port 3389
            - admin password (just incase)
        - ec2 instance connect
            - easiesst and safest method of cconnecting to ec2 linux
            - hov so
            - use iam policies to control acceess
            - does not require pem file

26. s3
    terminology
        - bucket
            - container for objectsc
            - total volume of data somehow are unlimited
            - bucket name have the rulesets for them 
        - object
            - entities
            - maximum is 5tb
            - largest object upload is 5gb (some how)
        - this thing is secure by default but can be modified through many thing like bucket policies, acl, iam policies

    1. storage classes
        - standard: lifecycle management
        - standard but with infrequent acess same feature, loower per gb storage price than standard
        - standard but with one zone ia: per gb retruieveal fee 
        - reduced redunadancy storage some how: retired and replacesd with ia 
        some how like that
        - special: s3 intelligent tiering
            - same features a standard ia witout retrieval fee
            - automatically moves objects between 2 access tier (like frequent and infrequent access) 
            - objects that have not been accessed for 30 days moved to the infrequent access
            - small montly monitoring and autoamtion fee
        - special: oobject level confirugratasd:\
            - SINGLE bucket but have contain s3 standard, s3 intelligent tearing, s3 standard ia, and s3 one zone ia
            

    2. glacier
     
    3. lifecycle

        - like, object delection after expiry time
        - object archiving to glacier after expiry time
        - canbe resotred from glacier back to s3 (I don't think we want to do that thing)
        - s3 versioning
            - preserves copoes of objentcs inside a bucket
            - individual pbijecas can be resotred to previous version
            -deleted objecnt can be recovered

    4. cross--region replication
        - like, reduced lantency for end user (have no idea thwatas hawk tuyaks  )
        - both source and destination buckets need versionning enabled if usign versioning
        - acl details updated
            -s3 eenabled encyasr tipn replicated
            - kms encryotion not replicated
        - sinces that have collecetasd, have some thing here
            - need to copy existing ibjct to new region,
            - repoicationas always take place between a pair of aws reguion 
            - bukckets can be soruce bu ker tfor anotehr cross region
    5. amazon macie (how we can monitor s3 bucket and modify skill issue)
        - uses ml and pattern machine to monitor, docerver and alert you to securitty issue with s3 buckets:
            -sensitive data such as persoanllyu idntification information like you
            - using one click and uysing command line inverface then  or api and sl
            - monitizing yuour bucket and find out your sensored information or security issues,m and create some solutiopns wich is more thign taosdijfa s

26. additional part: s3 version control and lifiecycle managemen
**somehow, we have to use that thing and create something, let's version control the s3 thing bullshit.: have to syncronize to other region, to only have one version of data which is downloadble from andyuser.
27. exploring the default 

28. cloudwatch

29. deployment on aws

30. cloud formation

31. aws analytics