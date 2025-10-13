## **The complete CICD pipeline (Continuous Integration and Continuous Deployment) - Block view version 1**

For the complete CICD pipeline, we will use the following services:
- **Block 1 - Source of truth**:
    - This is the only place where the code is stored and managed. Code, scripts, and configuration files are stored here.
    - This is the starting point of the CICD pipeline.
- **Block 2 - Trigger**:
    - When a change is made in the source of truth (Block 1), it triggers the CICD pipeline to start the process. We can name some action:
        - Code commit
        - Pull request
        - Merge request
        - Or regular schedule (e.g., daily, weekly)
- **Block 3 - Build**:
    - Compile the code to artifacts (e.g., binaries, libraries, Docker images). or file deployable.
    - T



CẤU TRÚC CỦA LAMBDA TRONG DỰ ÁN: LAMBDA 17 (BUILD JAR)


Dự án:
- Bình:  docKER COMPOSE VÀ ECS Deployment.
- Hưng: lambda maven và assiate các lambda functions