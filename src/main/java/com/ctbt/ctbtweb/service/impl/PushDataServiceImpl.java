package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.PushDataDao;
import com.ctbt.ctbtweb.entity.PushData;
import com.ctbt.ctbtweb.service.PushDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<PushData> findAll(Pageable pageable) {
        Page<PushData> pushDataPage = pushDataDao.findAll(pageable);
        return new PageImpl<PushData>(pushDataPage.getContent(), pageable, pushDataPage.getTotalElements());
    }

    @Override
    public PushData findById(int id) {
        return pushDataDao.findById(id).orElse(null);
    }

    @Override
    public List<PushData> findByName(String name) {
        return pushDataDao.findByName(name);
    }

    @Override
    public PushData findByIdOrName(int id, String name) {
        return pushDataDao.findByIdOrName(id, name);
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
