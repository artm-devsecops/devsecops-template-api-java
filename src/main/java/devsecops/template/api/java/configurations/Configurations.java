package devsecops.template.api.java.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

public class Configurations {
    @Configuration
    @ComponentScan("devsecops.template.api.java")
    public class Config {

    }
}
