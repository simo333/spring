package pl.simo333.task1_2;

import java.time.LocalDateTime;

public class SimpleCustomerLogger implements CustomerLogger {

    @Override
    public void log() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date + ": Customer operation");
    }
}
