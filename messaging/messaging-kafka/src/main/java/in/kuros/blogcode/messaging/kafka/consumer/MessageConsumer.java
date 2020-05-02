package in.kuros.blogcode.messaging.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "user-name")
    public void consume(final String message) {
        System.out.println("Received: " + message);
    }
}
