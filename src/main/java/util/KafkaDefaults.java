package main.java.util;

public class KafkaDefaults {
    // Properties
    public static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    public static final String GROUP_ID = "kafski";

    // Consumer config
    public static final long CONSUMER_POLL_FREQ_MILLIS= 100;

    // TODO<TW>: Find better way to store topics
    public static final String TOPIC_NAME = "tw-topic";
}
