package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.UserRolePermission;
import com.ctbt.ctbtweb.entity.UserRolePermissionId;
import com.ctbt.ctbtweb.service.UserRolePermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRolePermissionServiceImplTest {
    @Resource
    private UserRolePermissionService userRolePermissionService;

    @Test
    @Transactional
    public void save() {
        UserRolePermission userRolePermission = new UserRolePermission(
                new UserRolePermissionId(111, 111, "1"));
        UserRolePermission result = userRolePermissionService.save(userRolePermission);
        assertNotNull(result);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByUserRolePermissionId() {
        UserRolePermission userRolePermission = userRolePermissionService.findByUserRolePermissionId(
                new UserRolePermissionId(1, 10, "1"));
        assertNotNull(userRolePermission);
    }

    @Test
    public void findByUserRolePermissionIdUrId() {
        List<UserRolePermission> userRolePermissionList = userRolePermissionService.findByUserRolePermissionIdUrId(111);
        assertNotEquals(0, userRolePermissionList.size());
    }

    @Test
    public void findByUserRolePermissionIdPermId() {
    }
}