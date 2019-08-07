package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.VillageDao;
import com.ctbt.ctbtweb.domain.User;
import com.ctbt.ctbtweb.domain.Village;
import com.ctbt.ctbtweb.service.VillageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("villageService")
public class VillageServiceImpl implements VillageService {
    @Resource
    private VillageDao villageDao;

    @Override
    public Village save(Village village) {
        return villageDao.save(village);
    }

    @Override
    public void delete(Village village) {
        villageDao.delete(village);
    }

    @Override
    public Village update(Village village) {
        return villageDao.save(village);
    }

    @Override
    public Village findById(int id) {
        return villageDao.findById(id).orElse(null);
    }

    @Override
    public Page<Village> findAll(Pageable pageable) {
        Page<Village> villagePage = villageDao.findAll(pageable);
        return new PageImpl<Village>(villagePage.getContent(), pageable, villagePage.getTotalElements());
    }
}
