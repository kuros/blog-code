package in.kuros.blog.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class OrderPublisher {

    @Autowired Source source;

    @Scheduled(fixedDelay = 10000)
    public void publishOrder() {
        final Message<Order> message = MessageBuilder.withPayload(new Order("Order Number: " + System.currentTimeMillis())).build();
        source.output().send(message);
    }
}
