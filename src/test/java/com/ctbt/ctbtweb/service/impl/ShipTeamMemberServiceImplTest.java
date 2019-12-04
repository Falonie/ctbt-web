package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.ShipTeamMember;
import com.ctbt.ctbtweb.entity.ShipTeamMemberId;
import com.ctbt.ctbtweb.service.ShipTeamMemberService;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@Component
public class ShipTeamMemberServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private ShipTeamMemberService shipTeamMemberService;

    @Test
//    @Transactional
    public void save() {
        ShipTeamMember shipTeamMember = new ShipTeamMember(new ShipTeamMemberId(1000, 1000), "1");
        ShipTeamMember result = shipTeamMemberService.save(shipTeamMember);
        assertNotNull(result);
    }

    @Test
    public void findByShipTeamMemberId() {
        ShipTeamMember shipTeamMember = shipTeamMemberService.findByShipTeamMemberId(new ShipTeamMemberId(855911, 6));
        assertNotNull(shipTeamMember);
    }

    @Test
    public void shipTeamMemberList() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipTeamMember> shipTeamMemberPage = shipTeamMemberService.findByShipTeamMemberIdTeamId(6, request);
        assertNotEquals(0, shipTeamMemberPage.getTotalElements());
    }

    @Test
    @Transactional
    public void delete() {
        ShipTeamMember shipTeamMember = shipTeamMemberService.findByShipTeamMemberId(new ShipTeamMemberId(1000,1000));
        shipTeamMemberService.delete(shipTeamMember);
        assertNull(shipTeamMemberService.findByShipTeamMemberId(new ShipTeamMemberId(1000,1000)));
    }
}