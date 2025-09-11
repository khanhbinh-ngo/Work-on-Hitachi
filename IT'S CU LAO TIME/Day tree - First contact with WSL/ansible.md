1. what is ansible:
- they control how each server, app, containers,.. what to play, when, and how, so the whole system works in harmony.
- what it does?
    + configuration management
    + application deployment
    + IT orchestration
- concepts:
    + agentless: we didnt need other "tools" on the addressed device (agent) to connect. we use ssh (even though it is suck as fuck)
    + after ssh, we can change settings and more on the addressed device(s)
    + simple syntax:
        + describe tasks in yaml file as "play-book" (human being file- so that our co-workers can understand)
-usecase:
    + install packages and managing conflicts across the server
    + deploy apps automatically
    + setting up for cloud infrastructure (aws, azure...)
    + orchestrate multi-steps processes

2. how does it work?
