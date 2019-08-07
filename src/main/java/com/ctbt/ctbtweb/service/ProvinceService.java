package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {
    Province save(Province province);

    List<Province> findAll();

    Page<Province> findAll(Pageable pageable);

    List<Province> findAllByNationName(String nationName);

    Province findProvinceByProvinceName(String provinceName);

    Province findProvinceByProvinceId(int provinceId);

    void delete(Province province);
}
