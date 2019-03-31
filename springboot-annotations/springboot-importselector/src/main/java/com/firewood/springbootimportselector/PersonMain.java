package com.firewood.springbootimportselector;

import com.firewood.springbootimportselector.person.config.ChoosePersonConfig;
import com.firewood.springbootimportselector.person.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonMain {
    public static void main(String args[]){
        ApplicationContext context = new AnnotationConfigApplicationContext(ChoosePersonConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getJobName());

    }
}
