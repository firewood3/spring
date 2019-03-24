package com.firewood.springbootdatajpa;

import com.firewood.springbootdatajpa.model.Member;
import com.firewood.springbootdatajpa.model.type.MemberRole;
import com.firewood.springbootdatajpa.repository.MemberRepository;
import com.firewood.springbootdatajpa.service.SchoolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDataJpaApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);

        MemberRepository memberRepository = context.getBean(MemberRepository.class);
        memberRepository.save(new Member("LEE",33, MemberRole.ADMIN));
        Member lee = memberRepository.findByName("LEE");
        System.out.println(lee.toString());

        SchoolService schoolService = context.getBean(SchoolService.class);
        schoolService.addSchoolToStudent();
//        schoolService.addStudentsToSchool();
    }

}
