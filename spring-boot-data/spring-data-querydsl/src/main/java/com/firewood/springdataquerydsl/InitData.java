package com.firewood.springdataquerydsl;

import com.firewood.springdataquerydsl.entity.MemberEntity;
import com.firewood.springdataquerydsl.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Bean
    public ApplicationRunner init(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new MemberEntity("이창순",33));
            memberRepository.save(new MemberEntity("김대길",41));
            memberRepository.save(new MemberEntity("홍상이",23));
            memberRepository.save(new MemberEntity("박창재",53));
            memberRepository.save(new MemberEntity("안일권",24));
            memberRepository.save(new MemberEntity("노우진",41));
            memberRepository.save(new MemberEntity("이길재",22));
            memberRepository.save(new MemberEntity("이호재",53));
        };

    }
}
