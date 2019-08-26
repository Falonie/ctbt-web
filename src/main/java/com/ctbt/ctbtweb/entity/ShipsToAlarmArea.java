package com.ctbt.ctbtweb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SHIPSTOALARMAREA_TABLE")
@Data
@NoArgsConstructor
public class ShipsToAlarmArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "SHIPID")
    private int shipId;

    @Column(name = "AREAID")
    private int areaId;
}
