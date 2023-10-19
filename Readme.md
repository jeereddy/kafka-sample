Kafka sample project 

Use the below command to start the Zookeeper service:
# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
$ bin/zookeeper-server-start.sh config/zookeeper.properties

Open another terminal session and run the below command to start the Kafka broker:
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

Let's run the Spring boot application and have the demo. Make sure that Zookeeper and Kafka services should be up and running.

Open a browser and hit the below link to call a REST API:

http://localhost:8080/api/v1/kafka/publish?message=hello%20world