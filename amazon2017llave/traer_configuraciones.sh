#!/bin/bash
scp -i "librocomprasv3.pem"  ubuntu@ec2-52-55-47-82.compute-1.amazonaws.com:/home/ubuntu/*.sh .
scp -i "librocomprasv3.pem"  ubuntu@ec2-52-55-47-82.compute-1.amazonaws.com:/home/ubuntu/respaldosdb/*.dump respaldosdb
