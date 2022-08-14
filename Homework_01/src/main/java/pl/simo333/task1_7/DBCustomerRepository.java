package pl.simo333.task1_7;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.simo333.task1_1.Customer;
import pl.simo333.task1_2.CustomerLogger;
import pl.simo333.task1_3.CustomerRepository;

import javax.sql.DataSource;
import java.util.List;

public class DBCustomerRepository implements CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerLogger logger;
    private static final String ADD_QUERY = "INSERT INTO customers (firstname, lastname) VALUES (?, ?";
    private static final String DELETE_QUERY = "DELETE FROM customers WHERE id = ?";
    private static final String Find_ALL_QUERY = "SELECT * FROM customers";

    public DBCustomerRepository(DataSource dataSource, @Qualifier("DBCustomerLogger") CustomerLogger logger) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.logger = logger;
    }

    @Override
    public void addCustomer(Customer customer) {
        Object[] params = {customer.getFirstName(), customer.getLastName()};
        jdbcTemplate.update(ADD_QUERY, params);
        logger.log();
    }

    @Override
    public void deleteCustomer(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
        logger.log();
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = jdbcTemplate.queryForList(Find_ALL_QUERY, Customer.class);
        logger.log();
        return customers;
    }
}
