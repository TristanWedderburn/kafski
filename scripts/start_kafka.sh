# Start the ZooKeeper service
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &

sleep 5

# Start the Kafka broker service
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties &
