package pl.simo333.task1_5;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class DatabaseConfig {
    private static final String MY_SQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/homework1_db";
    private static final String DB_ROOT = "root";
    private static final String DB_PASSWORD = "root";

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(MY_SQL_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_ROOT);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }
}
