package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {
    Person findById(int id);

    Person findByName(String name);

    void deleteByName(String name);
}
