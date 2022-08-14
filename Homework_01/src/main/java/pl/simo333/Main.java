package pl.simo333;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.simo333.task1_1.Customer;
import pl.simo333.task1_2.AppConfig;
import pl.simo333.task1_3.MemoryCustomerRepository;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemoryCustomerRepository repo = context.getBean(MemoryCustomerRepository.class);
        System.out.println(repo.getCustomers());
        repo.addCustomer(new Customer(1L, "Sz", "Pn"));
        System.out.println(repo.getCustomers());
        repo.deleteCustomer(1L);
        System.out.println(repo.getCustomers());
    }

}
