load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "producer_lib",
    srcs = ["KafkaProducerImpl.java"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/util:util_lib",
        "@maven//:org_apache_kafka_kafka_clients",
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:ch_qos_logback_logback_classic"
    ],
)

java_binary(
    name="producer",
    main_class = "KafkaProducerImpl",
    runtime_deps = [":producer_lib"]
)
