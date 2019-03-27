package com.firewood.springbootmultidatasource.pg.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PgConfig {

    @Bean(name = "pgDataSource")
    @ConfigurationProperties(prefix = "pg.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
