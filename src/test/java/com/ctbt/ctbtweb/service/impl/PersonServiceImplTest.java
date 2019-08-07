package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.domain.Person;
import com.ctbt.ctbtweb.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {
    @Resource
    private PersonService personService;

    @Test
    public void findAll() {
        List<Person> personList = personService.findAll();
        assertNotEquals(0, personList.size());
    }

    @Test
    @Transactional
    public void save() {
        Person person = new Person();
        person.setName("testName");
        person.setPersonalPhone("1888888888");
        person.setIdEntityCard("11111111");
        person.setCompany("CTBT");
        person.setCompanyPhone("80082008820");
        person.setHomeAddress("AAAAAAAAAAA");
        person.setHomePhone("1888888888");
        person.setEmergencyContactPerson("testUser");
        person.setEmergencyContactNumber("1111111");
        person.setBloodType("A");
        person.setOthers("N/A");
        person.setEquipmentId("N/A");
        Person result = personService.save(person);
        System.out.println("********" + result + "********");
        assertNotNull(result);
    }

    @Test
    public void findOneById() {
        Person person = personService.findOneById(6);
        assertNotNull(person);
    }

    @Test
    public void findByName() {
        Person person=personService.findByName("张三");
        assertNotNull(person);
    }

    @Test
    @Transactional
    public void update() {
        Person person = personService.findOneById(6);
        person.setName("张三三");
        Person result = personService.update(person);
        assertNotNull(result);
        assertEquals("张三三", personService.findOneById(6).getName());
    }

    @Test
    @Transactional
    public void delete() {
        Person person = personService.findOneById(6);
        personService.delete(person);
        assertNull(personService.findOneById(6));
    }

}