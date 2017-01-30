#!/bin/bash
cp *.war  /var/lib/tomcat7/webapps
sudo /etc/init.d/tomcat7 restart
