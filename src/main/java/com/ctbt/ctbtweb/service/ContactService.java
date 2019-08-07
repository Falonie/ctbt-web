package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);

    Contact findOneByName(String name);

    Contact update(Contact contact);

    List<Contact> findAll();
}
