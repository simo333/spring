package pl.simo333.task1_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.simo333.task1_3.MemoryCustomerRepository;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public SimpleCustomerLogger logger() {
        return new SimpleCustomerLogger();
    }

    @Bean
    public MemoryCustomerRepository repo() {
        return new MemoryCustomerRepository(new SimpleCustomerLogger());
    }
}