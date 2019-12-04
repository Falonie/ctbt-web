package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ShipTeamMemberId implements Serializable {
    private int shipId;
    private int teamId;
}
