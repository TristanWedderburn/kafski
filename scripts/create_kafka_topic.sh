# Define topic to create
TOPIC=tw-topic

# TODO<TW>: Verify topic not already registered

# Create topic
$KAFKA_HOME/bin/kafka-topics.sh --create --topic $TOPIC --bootstrap-server localhost:9092

# Output topic describe
$KAFKA_HOME/bin/kafka-topics.sh --describe --topic $TOPIC --bootstrap-server localhost:9092
