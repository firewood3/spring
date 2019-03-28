package com.firewood.springbootdatamybatis;

import com.firewood.springbootdatamybatis.notice.Notice;
import com.firewood.springbootdatamybatis.notice.NoticeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootDataMybatisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDataMybatisApplication.class, args);

        NoticeRepository repository = run.getBean(NoticeRepository.class);
        System.out.println("----find ALL-----");
        repository
                .findAllNotice()
                .forEach(SpringbootDataMybatisApplication::println);

        System.out.println("\n----insert Notice : 10-----\n");
        repository.addNotice(new Notice(10L, "title-10", "content-10"));

        System.out.println("----find ALL-----");
        repository
                .findAllNotice()
                .forEach(SpringbootDataMybatisApplication::println);

        System.out.println("\n----find id : 1-----");
        Notice byId = repository.findById(1L);
        System.out.println(byId);
    }

    private static void println(Object o) {
        System.out.println(o.toString());
    }
}
