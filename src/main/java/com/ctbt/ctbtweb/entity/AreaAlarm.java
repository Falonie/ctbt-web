package com.ctbt.ctbtweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AREAALARM_TABLE")
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class AreaAlarm {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areaAlarm_seq")
	@SequenceGenerator(name = "areaAlarm_seq", sequenceName = "AREAALARMSEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;

	@Column(name = "EQUIPMENTID")
	private String equipmentId;

	@Column(name = "AREAID")
	private int areaId;

	@Column(name = "LOCSTATUS")
	private String locstatus;

	@Column(name = "ISVISITED")
	private String isvisited;

	@Column(name = "SHIPID")
	private int shipId;

	@Column(name = "ENTERTIME")
	private Date entertime;

	@Column(name = "LEAVETIME")
	private Date leavetime;

}
