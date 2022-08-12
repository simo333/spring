package pl.coderslab.extratasks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.config.AppConfig;
import pl.coderslab.extratasks.task1_1.Customer;
import pl.coderslab.extratasks.task1_3.MemoryCustomerRepository;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MemoryCustomerRepository customerRepository = context.getBean(MemoryCustomerRepository.class);
        customerRepository.getCustomers();
        customerRepository.addCustomer(new Customer(1L, "Sz", "Pn"));
        customerRepository.getCustomers();
        customerRepository.deleteCustomer(1L);
        customerRepository.getCustomers();
    }
}
