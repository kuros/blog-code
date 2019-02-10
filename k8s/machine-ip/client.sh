#!/bin/sh

for i in {1..10}
do
   response=$(curl -sb -H "Accept: application/json" "http://localhost:8080/ip")
   echo ${response}
done