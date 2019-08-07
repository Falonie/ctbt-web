package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);

    User findById(int id);

    User findByUsername(String name);

    User findByUsernameAndPassword(String name, String password);

    User update(User user);

    void delete(User user);

    Page<User> findAll(Pageable pageable);

//    User login(String name, String password);

    ServerResponse<User> login(String name,String password);
}
