package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.Role;
import com.ctbt.ctbtweb.service.RoleService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class RoleServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private RoleService roleService;

    @Test
    @Transactional
    public void save() {
        Role role = new Role("testRole", "testRoleDesc", "1");
        Role result = roleService.save(role);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        Role role = roleService.findOne(42);
        assertNotNull(role);
    }

    @Test
    public void findAll() {
        List<Role> roleList = roleService.findAll();
        assertNotEquals(0, roleList.size());
    }

    @Test
    @Transactional
    public void delete() {
        Role role = roleService.findOne(42);
        roleService.delete(role);
        assertNull(roleService.findOne(42));
    }
}