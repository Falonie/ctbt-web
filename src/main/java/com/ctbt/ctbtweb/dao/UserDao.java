package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    User findByUsernameAndPassword(String name, String password);

//    Page<User> findUsers(Pageable pageable);
}
