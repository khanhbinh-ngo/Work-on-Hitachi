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
    2. instance lifecycle

    3. storage options

    4. remote access

26. s3

27. exploring the default vps

28. cloudwatch

29. deployment on aws

30. cloud formation

31. aws analytics