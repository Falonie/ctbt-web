package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Contact;
import com.ctbt.ctbtweb.service.ContactService;
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
public class ContactServiceImplTest {
    @Resource
    private ContactService contactService;

    @Test
    @Transactional
    public void save() {
        Contact contact = new Contact();
        contact.setName("testUser");
        contact.setSendField("XXXXXXXXXXXX");
        contact.setSendState("XXXXXXXXXXXX");
        contact.setTel("18888888888");
        Contact result = contactService.save(contact);
        System.out.println("************" + result + "***********");
        assertNotNull(result);
    }

    @Test
    public void findOneByName() {
        Contact contact = contactService.findOneByName("孙海");
        System.out.println("************" + contact + "***********");
        assertNotNull(contact);
    }

    @Test
    @Transactional
    public void update() {
        Contact contact = contactService.findOneByName("孙海");
        contact.setName("孙海海");
        Contact result = contactService.update(contact);
        System.out.println("************" + result + "***********");
        assertNotNull(result);
    }

    @Test
    public void findAll() {
        List<Contact> contactList = contactService.findAll();
        assertNotEquals(0, contactList.size());
    }
}