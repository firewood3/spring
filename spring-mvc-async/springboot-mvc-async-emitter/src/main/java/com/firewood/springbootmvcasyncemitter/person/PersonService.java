package com.firewood.springbootmvcasyncemitter.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {
    private ArrayList<Person> people = new ArrayList<>();

    public PersonService() {
        people.add(new Person("KIM", 30));
        people.add(new Person("KO", 42));
        people.add(new Person("PARK", 21));
        people.add(new Person("OH", 64));
        people.add(new Person("CHO", 21));
        people.add(new Person("LEE", 11));
    }

    public ArrayList<Person> findAllPerson() {
        return people;
    }
}
