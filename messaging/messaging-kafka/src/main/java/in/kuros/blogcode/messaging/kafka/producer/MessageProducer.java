package in.kuros.blogcode.messaging.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final KafkaTemplate<String, String> producer;

    public void publishMessage(String message) {
        producer.send("user-name", message);
    }
}
