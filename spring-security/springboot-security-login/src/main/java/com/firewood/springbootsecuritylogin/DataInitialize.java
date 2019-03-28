package com.firewood.springbootsecuritylogin;

import com.firewood.springbootsecuritylogin.member.domain.Member;
import com.firewood.springbootsecuritylogin.member.domain.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitialize {

    @Bean
    public ApplicationRunner dataInit(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new Member("firewood","$2a$11$/1zHNZGuON3WQWXvxQ2dqe0OqNpXFS5DT9s5pUqs1J5EaSeNfc3b6","ROLE_USER","firewood@gmail.com", "010-91677-47984"));
            memberRepository.save(new Member("firewood1","$2a$11$/1zHNZGuON3WQWXvxQ2dqe0OqNpXFS5DT9s5pUqs1J5EaSeNfc3b6","ROLE_USER","firewood1@gmail.com", "010-91677-11111"));
            memberRepository.save(new Member("admin","$2a$11$/1zHNZGuON3WQWXvxQ2dqe0OqNpXFS5DT9s5pUqs1J5EaSeNfc3b6","ROLE_ADMIN","admin@firewood.com", "010-67914-11111"));
        };
    }
}
