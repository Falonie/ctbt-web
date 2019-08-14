package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    User findByUsernameAndPassword(String name, String password);

    User findByIdOrUsername(int id, String username);

//    Page<User> findUsers(Pageable pageable);
}
