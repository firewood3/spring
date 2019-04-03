package com.firewood.myspringbootmodule.autoconfig;

import com.firewood.myspringbootmodule.helloworld.HelloWorldService;
import com.firewood.myspringbootmodule.helloworld.HelloWorldServiceImpl;
import com.firewood.myspringbootmodule.person.PersonService;
import com.firewood.myspringbootmodule.person.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomAutoConfiguration {
    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldServiceImpl();
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
}
