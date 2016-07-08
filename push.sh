#!/bin/bash 
clear

git init
git clone https://github.com/Prakhar94/NewRepo.git
echo "clone"
pwd
cd NewRepo
touch readme.txt
git add readme.txt
git status
git commit -m "adding a text file"
git push https://Prakhar94:"Password"@github.com/Prakhar94/NewRepo.git
git commit -m "done"

echo "this is done"
