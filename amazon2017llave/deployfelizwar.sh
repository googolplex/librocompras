#!/bin/bash
cp *.war  /var/lib/tomcat7/webapps
cp *.jar  /usr/share/tomcat7/lib
sudo /etc/init.d/tomcat7 restart
