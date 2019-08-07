package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.PushDataDao;
import com.ctbt.ctbtweb.domain.PushData;
import com.ctbt.ctbtweb.service.PushDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("pushDataService")
public class PushDataServiceImpl implements PushDataService {
    @Resource
    private PushDataDao pushDataDao;

    @Override
    public List<PushData> findAll() {
        return pushDataDao.findAll();
    }

//    @Override
//    public List<PushData> findByName(String name) {
//        return pushDataDao.findByName(name);
//    }

    @Override
    public PushData findById(int id) {
        return pushDataDao.findById(id).orElse(null);
    }

    @Override
    public PushData save(PushData pushData) {
        return pushDataDao.save(pushData);
    }

    @Override
    public PushData update(PushData pushData) {
        return pushDataDao.save(pushData);
    }

    @Override
    public void delete(PushData pushData) {
        pushDataDao.delete(pushData);
    }
}
