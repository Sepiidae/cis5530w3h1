# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM tomcat8:latest

ADD target/cis5530w3h1-1.0-SNAPSHOT.war ./webapps/
