package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipTeamMember;
import com.ctbt.ctbtweb.entity.ShipTeamMemberId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipTeamMemberService {
    ShipTeamMember save(ShipTeamMember shipTeamMember);

    ShipTeamMember findByShipTeamMemberId(ShipTeamMemberId shipTeamMemberId);

    Page<ShipTeamMember> findByShipTeamMemberIdTeamId(int teamId, Pageable pageable);

    void delete(ShipTeamMember shipTeamMember);
}
