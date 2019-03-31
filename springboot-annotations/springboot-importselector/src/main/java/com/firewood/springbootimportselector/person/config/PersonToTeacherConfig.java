package com.firewood.springbootimportselector.person.config;

import com.firewood.springbootimportselector.person.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonToTeacherConfig {
    @Bean
    public Person person() {
        return new Person("Teacher");
    }
}
