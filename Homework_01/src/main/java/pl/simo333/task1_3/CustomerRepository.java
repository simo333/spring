package pl.simo333.task1_3;

import org.springframework.stereotype.Repository;
import pl.simo333.task1_1.Customer;


import java.util.List;

@Repository
public interface CustomerRepository {
    void addCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer> getCustomers();
}
