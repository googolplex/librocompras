#!/bin/bash
scp -i "librocomprasv3.pem"  *.jar ubuntu@ec2-52-200-184-169.compute-1.amazonaws.com:/home/ubuntu/
scp -i "librocomprasv3.pem"  *.war ubuntu@ec2-52-200-184-169.compute-1.amazonaws.com:/home/ubuntu/
scp -i "librocomprasv3.pem"  ../jasperfeliz/*.jrxml ubuntu@ec2-52-200-184-169.compute-1.amazonaws.com:/home/xoldfusion/Descargas/librocompras2017/jasperfeliz
