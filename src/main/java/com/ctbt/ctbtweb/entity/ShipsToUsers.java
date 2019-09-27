package com.ctbt.ctbtweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SHIPSTOUSERS_TABLE")
@Getter
@Setter
@ToString
public class ShipsToUsers {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipsToUsers_seq")
	@SequenceGenerator(name = "shipsToUsers_seq", sequenceName = "SHIPSTOUSERSSEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;

    @Column(name = "SHIPID")
//	private Ships ship;
	private int shipId;

    @Column(name = "USERID")
//	private User user;
	private int userId;

    @Column(name = "UPDATEEQUIPMENTIDDATE")
	private Date updateEquipmentIdDate; //最新修改卡号的时间

	public ShipsToUsers() {
		super();
	}
}
