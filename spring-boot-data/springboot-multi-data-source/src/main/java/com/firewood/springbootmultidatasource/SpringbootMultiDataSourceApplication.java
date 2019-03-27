package com.firewood.springbootmultidatasource;

import com.firewood.springbootmultidatasource.h2.domain.H2Notice;
import com.firewood.springbootmultidatasource.h2.domain.H2Repository;
import com.firewood.springbootmultidatasource.mysql.domain.MysqlNotice;
import com.firewood.springbootmultidatasource.mysql.domain.MysqlRepository;
import com.firewood.springbootmultidatasource.pg.domain.PgNotice;
import com.firewood.springbootmultidatasource.pg.domain.PgRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class SpringbootMultiDataSourceApplication {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootMultiDataSourceApplication.class, args);
//        testMysql(run);
//        testH2(run);
//        testPg(run);
    }

    private static void testMysql(ConfigurableApplicationContext context) throws SQLException {
        MysqlRepository repository = context.getBean(MysqlRepository.class);
        repository.connect();
        List<MysqlNotice> all = repository.findAll();
        all.forEach(mysqlNotice -> System.out.println(mysqlNotice.toString()));
    }

    private static void testH2(ConfigurableApplicationContext context) {
        H2Repository repository = context.getBean(H2Repository.class);
        List<H2Notice> all = repository.findAll();
        all.forEach(h2Notice -> System.out.println(h2Notice.toString()));
    }

    private static void testPg(ConfigurableApplicationContext context) throws SQLException {
        PgRepository repository = context.getBean(PgRepository.class);
        repository.connect();
        List<PgNotice> all = repository.findAll();
        all.forEach(pgNotice -> System.out.println(pgNotice.toString()));
    }
}
