package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.RoleToUserDao;
import com.ctbt.ctbtweb.entity.RoleToUser;
import com.ctbt.ctbtweb.service.RoleToUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleToUserService")
public class RoleToUserServiceImpl implements RoleToUserService {
    @Resource
    private RoleToUserDao roleToUserDao;

    @Override
    public List<RoleToUser> findAllByRoleId(int roleId) {
        return roleToUserDao.findAllByRoleId(roleId);
    }

//    @Override
//    public List<RoleToUser> findAllByRoleIdNot(int roleId) {
//        return roleToUserDao.findAllByRoleIdNot(roleId);
//    }

    @Override
    public RoleToUser findByUserIdAndRoleId(int userId, int roleId) {
        return roleToUserDao.findByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public RoleToUser save(RoleToUser roleToUser) {
        return roleToUserDao.save(roleToUser);
    }

    @Override
    public void delete(RoleToUser roleToUser) {
        roleToUserDao.delete(roleToUser);
    }
}
