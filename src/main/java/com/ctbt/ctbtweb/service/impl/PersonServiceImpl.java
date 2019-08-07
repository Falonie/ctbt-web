package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.PersonDao;
import com.ctbt.ctbtweb.domain.Person;
import com.ctbt.ctbtweb.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    public Person findOneById(int id) {
        return personDao.findById(id);
    }

    @Override
    public Person findByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public Person update(Person person) {
        return personDao.save(person);
    }

    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }
}
