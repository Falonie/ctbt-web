package com.ctbt.ctbtweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VILLAGE_TABLE")
//@Data
@Getter
@Setter
public class Village {

	public Village() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

//	@Column(name = "TOWNID")
//	private int townId;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
	@JoinColumn(name = "TOWNID")
	private Town town;
}
