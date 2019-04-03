package com.firewood.mycustomspringboot;

import com.firewood.myspringbootmodule.helloworld.HelloWorldService;
import com.firewood.myspringbootmodule.person.PersonService;
import com.firewood.myspringbootmodule.person.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyCustomSpringbootApplication implements CommandLineRunner {

    @Autowired
    HelloWorldService helloWorldService;

    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(MyCustomSpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        helloWorldService.printHelloWorld();
        Person person = personService.getPerson();
        System.out.println(person.getName());
        System.out.println(person.getAddress());
    }
}
