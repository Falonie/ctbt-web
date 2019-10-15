package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    Role findOne(int id);

    List<Role> findAll();

    void delete(Role role);
}
