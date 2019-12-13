package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.Permission;
import com.ctbt.ctbtweb.service.PermissionService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;

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
    public void findAllByPermId() {
        List<Permission> permissionList = permissionService.findByPermIdIn(List.of(16, 38, 43, 47, 48, 49));
        assertNotEquals(0, permissionList.size());
    }

    @Test
    public void delete() {
    }
}