#!/bin/bash
for i in {1..1}
do
   curl -d "@badRequest.json" -H "Content-Type: application/json" -X GET http://localhost:8080/getWeeklySummary -i 
done
