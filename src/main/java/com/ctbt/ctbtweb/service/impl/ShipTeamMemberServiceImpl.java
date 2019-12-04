package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipTeamMemberDao;
import com.ctbt.ctbtweb.entity.ShipTeamMember;
import com.ctbt.ctbtweb.entity.ShipTeamMemberId;
import com.ctbt.ctbtweb.service.ShipTeamMemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipTeamMemberService")
public class ShipTeamMemberServiceImpl implements ShipTeamMemberService {
    @Resource
    private ShipTeamMemberDao shipTeamMemberDao;

    @Override
    public ShipTeamMember save(ShipTeamMember shipTeamMember) {
        return shipTeamMemberDao.save(shipTeamMember);
    }

    @Override
    public ShipTeamMember findByShipTeamMemberId(ShipTeamMemberId shipTeamMemberId) {
        return shipTeamMemberDao.findById(shipTeamMemberId).orElse(null);
    }

    @Override
    public Page<ShipTeamMember> findByShipTeamMemberIdTeamId(int teamId, Pageable pageable) {
        Page<ShipTeamMember> shipTeamMemberPage = shipTeamMemberDao.findByShipTeamMemberIdTeamId(teamId, pageable);
        return new PageImpl<ShipTeamMember>(shipTeamMemberPage.getContent(), pageable, shipTeamMemberPage.getTotalElements());
    }

    @Override
    public void delete(ShipTeamMember shipTeamMember) {
        shipTeamMemberDao.delete(shipTeamMember);
    }
}
