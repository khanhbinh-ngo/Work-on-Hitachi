READING: ANSIBLE FOR DEVOPS

## I. Introduction: 

what is ansible:
- This is ONE of the best automation tool over the world
- more than that, we have things need to be use, based on how ansible supports us:
- unluckily, I have very low experience about managing server as well

- ansible typographic conventions:
    + yaml file
    + Code and sample commands will be used.

## II. Getting started with ansible

- we had to make any sense from the past by hand:
    + system administrators deployed, managed servers, installed software, changed configurations - by all their own hand
    + with the grow of amount of data and the growth of how many applications which is enabling on their own individual server.

- **MOdern infrastructure management**
    + server virtualization - large scale on infrastructure
    + Data growth - hosted applications - more complex - provision and management tool is on demand
    + systems run applications: more complex - development and operations is become fully integrated.

- when the developers thinks 'bout development and operations

- server admin on previous day:

- manage server by ssh to their server - making change - log off.
    - some of them should become more "documentating" (like documentation tasks)

- then this have the idea that we could use one tool - allows ssh to many server - admin documentating the tasks and make change at that tool - that tool automate ssh to several servers - make change as the documentations - log outlook

- admin no need to manually as previous day

- okay, if they wanted to deploy server exactly like one that is currently running then how? he wanted tho going through all installed app, packages, documenting configurations and so on, then he take time to manually setting a new server, restart, reinstall. all many unnecessary time would be consumpting

- then we are going to use something like bash command line. and some how ansible is made and maintained by sysadmin, who know the command line and want to make a tool helps manage their servers exactly the same as they have in the past, but repeatable and centrally managed ways,

- strength point of ansible: have ability to run regular shell command verbatim (verbatim = chính xác), so we can take existing scripts and commands and work on converting them into idempotent playbooks as time allowed.

- ansible works by pushing changes out to all your server as default and requires no extra software to be installed on the server. 

- ansible dependency is Python. once python is installed, then we can easily running by pip.

- ansible uses an inventory file (basically is a list of server) to communicate with your servers. like a hosts file (etc/host) that matches IP addresses to domain names.
- an ansible inventory is the place where store several hosts name, including your servers. it allows ansible contact and ssh to your server and make change with them.



III. Local infrastructure Development: ansible and vagrant

1. prototyping and testing with local virtual machine

then I have installed, set up one more wsl (for actually ssh from ansible)

- I mean, I could set up a new server OS (like pre config, then iso the folder which is the server like the standard version of that shit)
so, if we installed vagrant, then let's findout the ability of vagrant:
    -. network interface management: you can forward ports to a vm's then share the public network connection
    -. share folder management : vagrant set up share between your host machine and vm's within using NFS or (slower) native folder sharing in Virtual machine
    -. I mean:
        -. 1. Can deploy multiple VMs server with standard set up
        -. 2. After deployed multiple server, use ansible to maintain connections and config file with ansible playbooks. 
        -. 3. Config seperated task on playbooks, which is mapped exactly for each VMs service.

2. Your first local server: Setting up Vagrant
- Prepare:
    -, Download and install Vagrant and Virtual box
    -, Create the folder somewhere on hard device (keep vagrant file and provision instruction)
    -, Open Terminal then navigate to the folder. 


IV. Adhoc command

V. Ansible Playbook

VI. Ansible Playbook: beyond the basic

VII. Playbook Organization - Roles and Includes

VIII. Ansible Inventory 

IX. Ansible Cookbook

X. Deploy with ansible

XI. Server security with ansible (Advance)

XII. Automating your automation - Ansible Tower and CI/CD

After credit 1:"Using ansible on windows workstation"

After credit 2:"ansible best practices and conventions"