package com.ctbt.ctbtweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SHIPTYPE_TABLE")
//@Data
@Getter
@Setter
public class ShipType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "TYPENAME")
    private String typeName;
}
