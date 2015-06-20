package producer;


import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SimpleKafkaProducer {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        //props.put("metadata.broker.list", "kafka-test-001.epicdevs.com:9092,kafka-test-002.epicdevs.com:9092,kafka-test-003.epicdevs.com:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        ProducerConfig producerConfig = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<>(producerConfig);

        for(int i = 0 ; i < 10 ; i++) {
            KeyedMessage<String, String> message = new KeyedMessage<>("test", "Hello, World! "+ i); // Topic, Message
            producer.send(message);
            Thread.sleep(1000);
        }
        producer.close();
    }
}
