package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipTeamDao;
import com.ctbt.ctbtweb.dao.ShipsDao;
import com.ctbt.ctbtweb.entity.ShipTeam;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.enums.ResultEnum;
import com.ctbt.ctbtweb.exception.CtbtException;
import com.ctbt.ctbtweb.service.ShipTeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("shipTeamService")
public class ShipTeamServiceImpl implements ShipTeamService {
    @Resource
    private ShipTeamDao shipTeamDao;
    @Resource
    private ShipsDao shipsDao;

    @Override
    public ShipTeam save(int shipId, String teamName, int safeDistance) {
        Ships ships = shipsDao.findById(shipId);
        ShipTeam shipTeam = new ShipTeam();
        shipTeam.setTeamLeaderShipId(ships.getId());
        shipTeam.setTeamName(teamName);
        shipTeam.setTeamLeaderName(ships.getOwner());
        shipTeam.setTeamLeaderPhone(ships.getPhoneNumber());
        shipTeam.setSafeDistance(safeDistance);
        return shipTeamDao.save(shipTeam);
    }

    @Override
    public ShipTeam findById(int shipTeamId) {
        Optional<ShipTeam> shipTeam = shipTeamDao.findById(shipTeamId);
//        if (shipTeam.isEmpty()) {
//            throw new CtbtException(ResultEnum.SHIPTEAM_NOT_EXIST);
//        }
        return shipTeam.orElse(null);
    }

    @Override
    public Page<ShipTeam> findAll(Pageable pageable) {
        Page<ShipTeam> shipTeamPage = shipTeamDao.findAll(pageable);
        return new PageImpl<ShipTeam>(shipTeamPage.getContent(), pageable, shipTeamPage.getTotalElements());
    }

    @Override
    public List<ShipTeam> findAll() {
        return shipTeamDao.findAll();
    }

    @Override
    public void delete(ShipTeam shipTeam) {
        shipTeamDao.delete(shipTeam);
    }
}
