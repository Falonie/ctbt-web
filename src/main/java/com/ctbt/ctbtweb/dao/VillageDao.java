package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageDao extends JpaRepository<Village,Integer> {
//    Village findById(int id);
}
