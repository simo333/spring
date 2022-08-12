package pl.coderslab.extratasks.task1_1;

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
