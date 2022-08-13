package pl.simo333.task1_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.simo333.task1_3.MemoryCustomerRepository;
import pl.simo333.task1_4.FileCustomerLogger;

@Configuration
@ComponentScan("pl.simo333")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    @Primary
    public MemoryCustomerRepository repoFileLog() {
        return new MemoryCustomerRepository(new FileCustomerLogger("log.txt"));
    }
    @Bean
    public MemoryCustomerRepository repo() {
        return new MemoryCustomerRepository(new SimpleCustomerLogger());
    }
}