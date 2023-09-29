import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import main.java.util.KafkaDefaults;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProducerImpl {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerImpl.class);

    public static void main(String[] args) {
        // Create producer
        final KafkaProducer<String, String> producer = new KafkaProducer<>(generateProducerProperties());
        
        // Create a BufferedReader to read input from the console
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(true) {
                // Prompt user for input
                System.out.print("Enter a Record value to send to Consumer (or 'exit' to quit): \n");
                
                // Read user input
                String input = reader.readLine();

                // Check for exit command
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                // Create Producer record to send to topic
                final ProducerRecord<String, String> record = new ProducerRecord<>(KafkaDefaults.TOPIC_NAME, input);

                // Send Record
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        System.out.println("Message sent successfully to topic " + metadata.topic() + ", partition " + metadata.partition() + ", offset " + metadata.offset());
                    } else {
                        exception.printStackTrace();
                    }
                });
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            // Close the producer
            producer.close();
        }
    }

    private static Properties generateProducerProperties() {
        final Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaDefaults.BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
