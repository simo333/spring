package pl.simo333.task1_5;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.simo333.task1_2.CustomerLogger;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@Component
@Primary
public class DBCustomerLogger implements CustomerLogger {

    private static final String INSERT_LOG_QUERY = "INSERT INTO logs (DESCRIPTION, TIMESTAMP) VALUES (?, ?);";
    private final JdbcTemplate jdbcTemplate;

    public DBCustomerLogger(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void log() {
        String msg = "Customer updated";
        Object[] params = {msg, LocalDateTime.now()};
        jdbcTemplate.update(INSERT_LOG_QUERY, params);
    }
}
