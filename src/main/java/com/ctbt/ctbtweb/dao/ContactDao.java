package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
    Contact findByName(String name);
}
