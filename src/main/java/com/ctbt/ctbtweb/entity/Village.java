package com.ctbt.ctbtweb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "VILLAGE_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Village {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "village_seq")
	@SequenceGenerator(name = "village_seq", sequenceName = "VILLAGESEQ", allocationSize = 1)
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
