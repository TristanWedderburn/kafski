import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import main.java.util.KafkaDefaults;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerImpl {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    public static void main(String[] args) {
        // Create consumer
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(generateConsumerProperties());
        
        // Subscribe to topics
        consumer.subscribe(Collections.singletonList(KafkaDefaults.TOPIC_NAME));

        // Poll for new data
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(KafkaDefaults.CONSUMER_POLL_FREQ_MILLIS));

            records.forEach(record -> {
                LOG.info("Key: " + record.key() + ", Value: " + record.value());
                LOG.info("Partition: " + record.partition() + ", Offset:" + record.offset());
            });
        }
    }

    // TODO<TW>: Consider refactoring into util method
    private static Properties generateConsumerProperties() {
        final Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaDefaults.BOOTSTRAP_SERVERS);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, KafkaDefaults.GROUP_ID);
        // Note: "earliest" auto offset reset config reads all historical data in topic
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
}
