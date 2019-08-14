package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.NationDao;
import com.ctbt.ctbtweb.entity.Nation;
import com.ctbt.ctbtweb.service.NationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("nationService")
public class NationServiceImpl implements NationService {
    @Resource
    private NationDao nationDao;

    @Override
    public Nation save(Nation nation) {
        return nationDao.save(nation);
    }

    @Override
    public Nation findOne(int id) {
        return nationDao.findNationByNationId(id);
    }

    @Override
    public Nation findOneByName(String name) {
        return nationDao.getNationByName(name);
    }

    @Override
    public int deleteByNationId(int nationId) {
        return nationDao.deleteByNationId(nationId);
    }

    @Override
    public List<Nation> findAll() {
        return nationDao.findAll();
    }
}
