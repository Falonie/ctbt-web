package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.NationDao;
import com.ctbt.ctbtweb.dao.ProvinceDao;
import com.ctbt.ctbtweb.domain.Nation;
import com.ctbt.ctbtweb.domain.Province;
import com.ctbt.ctbtweb.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceDao provinceDao;
    @Resource
    private NationDao nationDao;

    @Override
    public Province save(Province province) {
        return provinceDao.save(province);
    }

    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        Page<Province> provincePage = provinceDao.findAll(pageable);
        return new PageImpl<Province>(provincePage.getContent(), pageable, provincePage.getTotalElements());
    }

    @Override
    public List<Province> findAllByNationName(String nationName) {
        Nation nation = nationDao.getNationByName(nationName);
        return provinceDao.findAllByNationId(nation.getNationId());
    }

    @Override
    public Province findProvinceByProvinceName(String provinceName) {
        return provinceDao.findByName(provinceName);
    }

    @Override
    public Province findProvinceByProvinceId(int provinceId) {
        return provinceDao.findByProvinceId(provinceId);
    }

    @Override
    public void delete(Province province) {
        provinceDao.delete(province);
    }
}
