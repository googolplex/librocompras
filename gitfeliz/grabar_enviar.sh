#!/bin/bash
cp -R /home/xoldfusion/Downloads/openxava-5.6/workspace/librocomprasv3/*  librocompras/librocomprasv3
cp /home/xoldfusion/Downloads/openxava-5.6/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "primer commit"
git push -u origin master
