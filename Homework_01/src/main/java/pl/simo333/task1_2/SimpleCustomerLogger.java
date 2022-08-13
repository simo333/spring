package pl.simo333.task1_2;

import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

public class SimpleCustomerLogger implements CustomerLogger {

    @Bean
    public SimpleCustomerLogger getInstance() {
        return new SimpleCustomerLogger();
    }

    @Override
    public void log() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date + ": Customer operation");
    }
}
