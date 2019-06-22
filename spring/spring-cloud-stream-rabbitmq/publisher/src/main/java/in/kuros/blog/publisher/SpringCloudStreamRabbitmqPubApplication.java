package in.kuros.blog.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCloudStreamRabbitmqPubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamRabbitmqPubApplication.class, args);
    }

}
