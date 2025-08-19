### **Controlling Cost in your AWS services**
### **S3 bucket:>**
- Create bucket
- upload file to the bucket
- download file from the bucket
- cleaning bucket

### **SQL using RDS**
1. Creating security group

    By default, we are prohibited to access our database from the internet, so we have to create a security group that defines an inbound rule allows access from the internet (to our database).
    We can then associate this group to our database instance

- Create a virtual private cloud (VPC)
    - the VPC is the first firebase when we wanted how our operations, our app users or people interact with database (private, public or collected)
    - search VPC
    - look for security, then the security group
    (this step is actually create our own SG, so that we create roles, how or who could access to our database)
    - to access from the internet, at the inbound rule, we wanted to add access permission to our database, so we choose mysql/aurora
    - also, this is the fresh rule. more specifically set up, only confirmed or allowed IP address could access to our database, to make it more secured and prevent uncovered connections
- RDS database (RDS means Related Database Services)
    - we would create the first database (which is completely fresh and free to use - a trial one)
    - more over, we are using those database thousand times later, so make sure that we are doing all good things on them
    - after finish it up, we are easily connect our database through the internet 
- Connecting to RDS instance
    + trouble shooting and clear after testing
- I created a MariaDB and connect with Dbeaver. Kind of fund at that moment

### **Web server with EC2**
- Launch an EC2 instance: in this things, we will launch a publicly accessible workpress application on amazon ec2
    + I created the things named ec2
- view your web server 
- work with wordpress application
- your username and password through wordpress application
- cleaning up when finished

### **User monitoring with AWS Cloud trial**
we finished almost todolist for 19.8.25