#!/bin/bash
# hecho para mi pc de escritorio
cp -r /home/xoldfusion/Descargas/openxava-5.6_librocompras/workspace/librocomprasv3  librocompras
cp /home/xoldfusion/Descargas/openxava-5.6_librocompras/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cp -r openshiftfeliz librocompras/
rm *.*~
cd librocompras
git add -A
git commit -a -m "subo al openshift"
git push -u origin master
