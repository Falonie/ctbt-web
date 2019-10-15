package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Integer> {
    List<Role> findAll();
}
