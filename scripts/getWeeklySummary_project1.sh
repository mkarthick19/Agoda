#!/bin/bash
for i in {1..1}
do
 	curl -d "@project1.json" -H "Content-Type: application/json" -X GET http://localhost:8080/getWeeklySummary  
done
