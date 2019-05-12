package in.kuros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "in.kuros.entity")
@EnableJpaRepositories(basePackages = "in.kuros.repository")
public class SpringSecurityAuthenticationProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthenticationProviderApplication.class, args);
    }

}
