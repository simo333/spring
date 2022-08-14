package pl.simo333.task1_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.simo333.task1_4.FileCustomerLogger;

@Configuration
@ComponentScan("pl.simo333")
public class AppConfig {

    @Bean
    public CustomerLogger customerLogger() {
        return new FileCustomerLogger("log.txt");
    }
}