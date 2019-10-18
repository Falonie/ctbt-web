package com.ctbt.ctbtweb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_TABLE")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq", sequenceName = "PERSONSEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EQUIPMENTID")
    private String equipmentId;

    @Column(name = "PERSONALPHONE")
    private String personalPhone;

    @Column(name = "IDENTITYCARD")
    private String idEntityCard;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "COMPANYPHONE")
    private String companyPhone;

    @Column(name = "HOMEADDRESS")
    private String homeAddress;

    @Column(name = "HOMEPHONE")
    private String homePhone;

    @Column(name = "EMERGENCYCONTACTPERSON")
    private String emergencyContactPerson;

    @Column(name = "EMERGENCYCONTACTNUMBER")
    private String emergencyContactNumber;

    @Column(name = "BLOODTYPE")
    private String bloodType;

    @Column(name = "OTHERS")
    private String others;
}
