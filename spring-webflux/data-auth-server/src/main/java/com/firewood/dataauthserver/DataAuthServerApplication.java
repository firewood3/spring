package com.firewood.dataauthserver;

import com.firewood.dataauthserver.user.User;
import com.firewood.dataauthserver.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAuthServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner userDataInit(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("wood", "wood","wood-1234567890"));
            userRepository.save(new User("test", "test","test-1234567890"));
            System.out.println("user data saved");
        };

    }

}
