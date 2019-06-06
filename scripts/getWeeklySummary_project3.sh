#!/bin/bash
for i in {1..1}
do
   curl -d "@project3.json" -H "Content-Type: application/json" -X GET http://localhost:8080/getWeeklySummary -i
done
