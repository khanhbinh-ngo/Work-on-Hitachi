Firstly, we have to setting up an open ssh connection from your ubunu

on your ubuntu, let's have some setup:

    > sudo apt update $$ upgrade 
    > sudo apt install net-tools -y (install net-tools to monitor)
- install ssh service
    > sudo apt install openssh-server
    > service ssh status
- or 
    > sudo systemctl status ssh
- incase not active:
    > sudo systemctl enable --now ssh
- allowing ssh through the firewall:
    > sudo ufw allow ssh
- then config that ssh through the password.
    > sudo vim /etc/ssh/sshd_Config
- submit some config:

    + PermitRootLogin no
    + PasswordAuthentication yes
- then restart the service:
    > sudo service ssh restart

at wsl (the alma one)
    > ssh [username]@[ip address]

done