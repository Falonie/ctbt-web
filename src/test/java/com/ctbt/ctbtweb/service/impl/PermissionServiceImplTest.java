package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.Permission;
import com.ctbt.ctbtweb.service.PermissionService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@Component
public class PermissionServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private PermissionService permissionService;

    @Test
    public void save() {
    }

    @Test
    public void findByPermId() {
        Permission permission = permissionService.findByPermId(21);
        System.out.println(permission);
        assertNotNull(permission);
    }

    @Test
    public void delete() {
    }
}