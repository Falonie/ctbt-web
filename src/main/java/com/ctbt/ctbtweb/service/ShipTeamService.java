package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShipTeamService {
    ShipTeam save(int shipId,String teamName,int safeDistance);

    ShipTeam findById(int shipTeamId);

    Page<ShipTeam> findAll(Pageable pageable);

    List<ShipTeam> findAll();

    void delete(ShipTeam shipTeam);
}
