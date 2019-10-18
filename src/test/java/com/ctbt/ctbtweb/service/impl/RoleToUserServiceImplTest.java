package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.Role;
import com.ctbt.ctbtweb.entity.RoleToUser;
import com.ctbt.ctbtweb.service.RoleToUserService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class RoleToUserServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private RoleToUserService roleToUserService;

    @Test
    public void findAllByRoleId() {
        List<RoleToUser> roleToUserList = roleToUserService.findAllByRoleId(3);
        System.out.println(roleToUserList);
        assertNotEquals(0, roleToUserList.size());
    }

    @Test
    public void findAllByRoleIdNot() {
//        List<RoleToUser> roleToUserList = roleToUserService.findAllByRoleIdNot(3);
//        System.out.println("++++++++"+roleToUserList.size());
//        assertNotEquals(0, roleToUserList.size());
    }

    @Test
//    @Transactional
    public void save() {
        RoleToUser roleToUser = new RoleToUser(856, 3);
        RoleToUser result = roleToUserService.save(roleToUser);
        assertNotNull(result);
    }

    @Test
    public void findByUserIdAndRoleId() {
        RoleToUser roleToUser = roleToUserService.findByUserIdAndRoleId(856, 3);
        assertNotNull(roleToUser);
    }

    @Test
//    @Transactional
    public void delete() {
        RoleToUser roleToUser = roleToUserService.findByUserIdAndRoleId(856, 3);
        roleToUserService.delete(roleToUser);
        assertNull(roleToUserService.findByUserIdAndRoleId(856, 3));
    }
}