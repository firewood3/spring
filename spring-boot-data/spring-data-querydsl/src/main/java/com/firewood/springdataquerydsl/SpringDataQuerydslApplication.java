package com.firewood.springdataquerydsl;

import com.firewood.springdataquerydsl.entity.MemberEntity;
import com.firewood.springdataquerydsl.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataQuerydslApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringDataQuerydslApplication.class, args);
        MemberRepository memberRepository = run.getBean(MemberRepository.class);
        List<MemberEntity> allLike = memberRepository.findAllLike("%이%");
        for(MemberEntity m : allLike) {
            System.out.println(m.toString());
        }
    }

}
