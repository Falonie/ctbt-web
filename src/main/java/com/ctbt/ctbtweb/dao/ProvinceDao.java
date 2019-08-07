package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceDao extends JpaRepository<Province, Integer> {
    List<Province> findAllByNationId(int nationId);

    Province findByName(String provinceName);

    Province findByProvinceId(int provinceId);
}
