package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsToUsersDao;
import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipsToUsersService")
public class ShipsToUsersServiceImpl implements ShipsToUsersService {
    @Resource
    private ShipsToUsersDao shipsToUsersDao;

    @Override
    public Page<ShipsToUsers> findByUserId(int userId, Pageable pageable) {
        Page<ShipsToUsers> shipsToUsersPage = shipsToUsersDao.findByUserId(userId, pageable);
        return new PageImpl<ShipsToUsers>(shipsToUsersPage.getContent(), pageable, shipsToUsersPage.getTotalElements());
    }
}
