package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.PermissionDao;
import com.ctbt.ctbtweb.entity.Permission;
import com.ctbt.ctbtweb.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    @Override
    public Permission save(Permission permission) {
        return permissionDao.save(permission);
    }

    @Override
    public Permission findByPermId(int permId) {
        return permissionDao.findByPermId(permId);
    }

    @Override
    public void delete(Permission permission) {
        permissionDao.delete(permission);
    }
}
