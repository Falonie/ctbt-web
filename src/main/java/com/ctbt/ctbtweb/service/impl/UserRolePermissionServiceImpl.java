package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.UserRolePermissionDao;
import com.ctbt.ctbtweb.entity.UserRolePermission;
import com.ctbt.ctbtweb.entity.UserRolePermissionId;
import com.ctbt.ctbtweb.service.UserRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userRolePermissionService")
public class UserRolePermissionServiceImpl implements UserRolePermissionService {
    @Resource
    private UserRolePermissionDao userRolePermissionDao;

    @Override
    public UserRolePermission save(UserRolePermission userRolePermission) {
        return userRolePermissionDao.save(userRolePermission);
    }

    @Override
    public void delete(UserRolePermission userRolePermission) {
        userRolePermissionDao.delete(userRolePermission);
    }

    @Override
    public UserRolePermission findByUserRolePermissionId(UserRolePermissionId userRolePermissionId) {
        return userRolePermissionDao.findByUserRolePermissionId(userRolePermissionId);
    }

    @Override
    public List<UserRolePermission> findByUserRolePermissionIdUrId(int urId) {
        return userRolePermissionDao.findByUserRolePermissionIdUrId(urId);
    }

    @Override
    public List<UserRolePermission> findByUserRolePermissionIdPermId(int permId) {
        return userRolePermissionDao.findByUserRolePermissionIdPermId(permId);
    }

    @Override
    public List<UserRolePermission> findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(int urId, String permType) {
        return userRolePermissionDao.findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(urId, permType);
    }
}
