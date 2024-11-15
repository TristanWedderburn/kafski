# kafski
Kafka example

## Usage

- Export `$KAFKA_HOME` env variable for scripts

To run the Consumer:
- Run `bazel build //src/main/java/consumer:consumer_lib` to build the Consumer target 
- Run `bazel build //src/main/java/consumer:consumer_deploy.jar` to package the Consumer target in a deployable .jar
- Run `java -jar bazel-bin/src/main/java/consumer/consumer_deploy.jar` to run the Consumer

To run the Producer:
- Run `bazel build //src/main/java/producer:producer_lib` to build the Producer target
- Run `bazel build //src/main/java/producer:producer_deploy.jar` to package the Producer target in a deployable .jar
- Run `java -jar bazel-bin/src/main/java/producer/producer_deploy.jar` to run the Producer

# Development Notes
- Followed https://bazel.build/start/java#package_a_java_target_for_deployment to introduce Bazel to project
- Kafka quickstart: https://kafka.apache.org/quickstart
- Consumer example: https://www.conduktor.io/kafka/complete-kafka-consumer-with-java/

## Best Practices
- https://bazel.build/configure/best-practices
