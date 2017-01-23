#!/bin/bash
cp /home/xoldfusion/Downloads/openxava-5.6/tomcat/conf/*.xml librcompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "primer commit"
git push -u origin master
