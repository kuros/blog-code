package in.kuros.blog.publisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class LoggingListener {

    @StreamListener(Sink.INPUT)
    public void log(Message<Order> orderMessage) {
        System.out.println(orderMessage.getPayload());
    }
}
