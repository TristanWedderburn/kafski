# kafski
Kafka example

## Usage

To run the Consumer:
- Run `bazel build //src/main/java/consumer:consumer_lib ` to build the Consumer target 
- Run `bazel build //src/main/java/consumer:consumer_deploy.jar` to package the Consumer target in a deployable .jar
- Run `java -jar bazel-bin/src/main/java/consumer/consumer_deploy.jar` to run the Consumer

# Development Notes
- Followed https://bazel.build/start/java#package_a_java_target_for_deployment to introduce Bazel to project
- Kafka quickstart: https://kafka.apache.org/quickstart
- Consumer example: https://www.conduktor.io/kafka/complete-kafka-consumer-with-java/

## Best Practices
- https://bazel.build/configure/best-practices
