package com.firewood.conditional.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalTestMain {
    public static void main(String[] args) {
        Package pack = ConditionalTestMain.class.getPackage();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(pack.getName());
        context.refresh();
        Person person = context.getBean(Person.class);
        System.out.println(person.getJob());
    }
}
