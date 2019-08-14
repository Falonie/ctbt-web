package com.ctbt.ctbtweb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "HARBOUR_TABLE")
@Data
public class Harbor {

	public Harbor() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

//	@Column(name = "")
//	private int fatherId;
	@Column(name = "GEOMETRY")
	private String geometry;
}
