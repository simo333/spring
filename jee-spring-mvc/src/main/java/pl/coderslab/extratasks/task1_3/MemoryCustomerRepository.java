package pl.coderslab.extratasks.task1_3;

import pl.coderslab.extratasks.task1_1.Customer;
import pl.coderslab.extratasks.task1_1.CustomerLogger;

import java.util.ArrayList;
import java.util.List;

public class MemoryCustomerRepository implements CustomerRepository {
    private final List<Customer> customers;
    private final CustomerLogger logger;

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
        customers.stream()
                .filter(c -> id.equals(c.getId()))
                .forEach(customers::remove);
        logger.log();
    }

    @Override
    public List<Customer> getCustomers() {
        logger.log();
        return customers;
    }
}
