package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ContactDao;
import com.ctbt.ctbtweb.entity.Contact;
import com.ctbt.ctbtweb.service.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Resource
    private ContactDao contactDao;

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public Contact findOneByName(String name) {
        return contactDao.findByName(name);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
