package com.ctbt.ctbtweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SAILOR_TABLE")
@Data
@NoArgsConstructor
public class Sailor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sailor_seq")
    @SequenceGenerator(name = "sailor_seq", sequenceName = "SAILORSEQ", allocationSize = 1)
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
}
