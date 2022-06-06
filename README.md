Title: Building docker images and planning for services

Prompt: We are ending week 4 and if you completed reading IV of the book, it is time to start talking about deploying services. Last week's homework required that you plan a server deployment on physical and cloud hardware. During that assignment, you learned that physical equipment costs more on day one but costs less over the life of the hardware which is typically 5 - 7 years. Cloud however brings many very useful features and options to a deployment which in many cases allows it to be a more cost-effective solution. (For instance when automatic scaling is utilized). 

Notice 1: This assignment requires the installation of Docker Desktop which on Windows requires Windows Sub System for Linux. If your computer is running 32-bit Windows please contact the instructor for assistance. Also if you computer doesn't support virtualization extensions (docker will tell you) please reach out to the instructor.

Notice 2: If you are running Windows on a virtual Machine please reach out to the instructor for assistance to prevent damage to your Windows virtual machine.

Notice 3: The following procedure works on Intel Macs, ARM Mac, Linux, and Windows 10/11 (x64). Windows users may need to enable Windows Sub System for Linux 2, please follow the instructions and prompts on your PC. If you get stuck please reach out to the instructor immediately. Do NOT wait until the last day to complete this assignment.

Instructions to get dependencies setup: (50%)

Install Docker on your computer following the instructions from https://www.docker.com/products/docker-desktop/ (Links to an external site.)
Install Git from https://git-scm.com/downloads (Links to an external site.) 
Likely you will need to reboot your computer
Open cmd.com by clicking the start menu and typing cmd.com
Clone the homework repository by typing
git clone https://github.com/Sepiidae/cis5530w3h1 (Links to an external site.)
Change directory to cis5530w3h1
cd cis5530w3h1
Execute Docker-Compose to build the project
docker-compose build
Use docker-compose to start the project in the foreground
docker-compose up 
or to put the background
dcker-compose up -d 
Visit http://localhost:8080/cis5530w3h1 (Links to an external site.)
Tasks:

This week's homework asks that you deploy a service using three very small docker instances. 

A Load Balancer - nginx
An Application Server and Servlet - tomcat
A database server - db

Once you have completed all the dependency tasks you will be able to start playing with scaling the services.

Task 1: (25%)

First visit: http://localhost/cis5530w3h1/databaseServlet (Links to an external site.) to setup the database.
Now visit http://localhost/cis5530w3h1/indexServlet (Links to an external site.)  and press the refresh button 5 - 10 times.
Now visit: http://localhost/cis5530w3h1/databaseServlet (Links to an external site.) to view the access log
Copy-paste your access log into a word document and label it with "Task 1" you will turn this in (record the maximum id number)
Task 2: (25%)

Use the docker-compose yaml file to increase the default replica to 2. 
Execute docker-compose up -d to increase the replica count
Wait 60 seconds
Now visit http://localhost/cis5530w3h1/indexServlet (Links to an external site.)  and press the refresh button 5 - 10 times.
Now visit: http://localhost/cis5530w3h1/databaseServlet (Links to an external site.) to view the access log
Copy-paste your access log into a word document and label it with "Task 2" you will turn this in (record the maximum id number)
Task 3: (25%)

Use the docker-compose scale parameter (https://docs.docker.com/compose/compose-file/compose-file-v3/ (Links to an external site.)) to increase the replica count to the 3.
Wait 60 seconds
Now visit http://localhost/cis5530w3h1/indexServlet (Links to an external site.)  and press the refresh button 5 - 10 times.
Now visit: http://localhost/cis5530w3h1/databaseServlet (Links to an external site.) to view the access log
Copy-paste your access log into a word document and label it with "Task 3" you will turn this in (record the maximum id number)
Task 4: (Bonus 25%)

Without breaking the entire system enable HTTPS in the NGINX docker instance.
Attach a screenshot of the Chrome/Firefox/Edge Certificate page for https://localhost/. (Links to an external site.).
Example:
Screen Shot 2022-06-06 at 12.12.26 AM.png
 

What to turn in:

Submit a single word document containing the following. 

The output of a "docker version" as it shows that docker is running.
The output for Task 1.
The output for Task 2.
The output for Task 3.
Optional the output for enabling SSL.
.

Due:  Sunday @ midnight

Points: 100