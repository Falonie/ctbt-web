package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.RoleDao;
import com.ctbt.ctbtweb.entity.Role;
import com.ctbt.ctbtweb.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role findOne(int id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void delete(Role role) {
        roleDao.delete(role);
    }
}
