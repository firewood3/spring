package com.firewood.myspringbootmodule.person;

import com.firewood.myspringbootmodule.person.data.Person;

public class PersonServiceImpl implements PersonService{
    @Override
    public Person getPerson() {
        return new Person("alson", "from custom module") ;
    }
}
