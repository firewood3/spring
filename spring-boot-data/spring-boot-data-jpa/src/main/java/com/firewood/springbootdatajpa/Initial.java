package com.firewood.springbootdatajpa;

import com.firewood.springbootdatajpa.model.Member;
import com.firewood.springbootdatajpa.model.type.MemberRole;
import com.firewood.springbootdatajpa.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Initial {

    @Bean
    public ApplicationRunner runner(MemberRepository memberRepository) {
        return args->{
            memberRepository.save(new Member("Kim",33, MemberRole.USER));
        };
    }
}
