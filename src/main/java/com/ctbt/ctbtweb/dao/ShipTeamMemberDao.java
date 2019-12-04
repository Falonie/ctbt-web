package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipTeamMember;
import com.ctbt.ctbtweb.entity.ShipTeamMemberId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipTeamMemberDao extends JpaRepository<ShipTeamMember, ShipTeamMemberId> {
    Page<ShipTeamMember> findByShipTeamMemberIdTeamId(int teamId, Pageable pageable);
}
