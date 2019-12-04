package com.ctbt.ctbtweb.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CTBT_SHIP_TEAM_MEMBER")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShipTeamMember {
    @EmbeddedId
    private ShipTeamMemberId shipTeamMemberId;

    private String workStatus;
}
