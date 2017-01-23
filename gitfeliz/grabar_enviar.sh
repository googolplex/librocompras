#!/bin/bash
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "primer commit"
git push -u origin master
