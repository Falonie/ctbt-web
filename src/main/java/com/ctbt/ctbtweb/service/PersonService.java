package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person save(Person person);

    Person findOneById(int id);

    Person findByName(String name);

    Person update(Person person);

    void delete(Person person);
}
