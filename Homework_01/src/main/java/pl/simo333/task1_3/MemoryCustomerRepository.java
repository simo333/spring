package pl.simo333.task1_3;


import org.springframework.beans.factory.annotation.Autowired;
import pl.simo333.task1_1.Customer;
import pl.simo333.task1_2.CustomerLogger;

import java.util.ArrayList;
import java.util.List;

public class MemoryCustomerRepository implements CustomerRepository {
    private final List<Customer> customers;
    private final CustomerLogger logger;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger logger) {
        this.customers = new ArrayList<>();
        this.logger = logger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        logger.log();
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customers.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No customer found."));
        customers.remove(customer);
        logger.log();
    }

    @Override
    public List<Customer> getCustomers() {
        logger.log();
        return customers;
    }
}
