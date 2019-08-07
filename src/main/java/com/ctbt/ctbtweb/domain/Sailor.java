package com.ctbt.ctbtweb.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SAILOR_TABLE")
//@Data
@Getter
@Setter
public class Sailor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "IDENTITYCARDNUMBER")
	private String identityCardNumber;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "SHIPSID",referencedColumnName = "ID")
//	private Ships ships;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADRESS")
	private String adress;

	@Column(name = "WEAKNESSHISTORY")
	private String weaknessHistory;

	public Sailor() {
		super();
	}
}
