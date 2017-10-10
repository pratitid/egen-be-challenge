# egen-be-challenge
Egen Code Challenge

•	consumes data from the emulator via HTTP API and stores it in a MongoDB collection using Morphia API 

•	exposes the below Metric APIs using Spring MVC,
o	create – this is the API that will consume data from the sensor emulator
POST URL : http://localhost:8080/iotService/create
o	read – reads all the metrics stored in your database
GET URL: http://localhost:8080/iotService/readMetric
o	readByTimeRange – reads all the metrics that were created between the given two timestamps
GET URL: http://localhost:8080/iotService/readMetricByRange?start=startTimeStamp&end=endTimeStamp
eg- http://localhost:8080/iotService/readMetricByRange?start=1458062848775&end=1458062848785
•	exposes the below Alert APIs using Spring MVC
o	read – reads all alerts that are stored in the database
GET URL: http://localhost:8080/iotService/readAlerts
o	readByTimeRange – reads all alerts that are created between the given two timestamps
GET URL: http://localhost:8080/iotService/readAlertByRange?start=startTimeStamp&end=endTimeStamp
eg- http://localhost:8080/iotService/readAlertByRange?start=1458062848775&end=1458062848805

