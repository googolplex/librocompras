#!/bin/bash
# hecho para mi portatil
cp -r /home/xoldfusion/Downloads/openxava-5.6/workspace/librocomprasv3  librocompras
cp /home/xoldfusion/Downloads/openxava-5.6/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "dia dos - segundo commit"
git push -u origin master
