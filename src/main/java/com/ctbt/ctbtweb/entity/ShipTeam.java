package com.ctbt.ctbtweb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CTBT_SHIP_TEAM")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShipTeam {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipTeam_seq")
	@SequenceGenerator(name = "shipTeam_seq", sequenceName = "SEQ_CTBT_SHIP_TEAM_ID", allocationSize = 1)
	private int teamId;
	private String teamName;
	private int teamLeaderShipId;
	private String teamLeaderName;
	private String teamLeaderPhone;
	private int safeDistance;
}
