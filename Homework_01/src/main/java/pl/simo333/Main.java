package pl.simo333;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.simo333.task1_2.AppConfig;
import pl.simo333.task1_2.SimpleCustomerLogger;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger log = context.getBean(SimpleCustomerLogger.class);
        log.log();
    }

}
