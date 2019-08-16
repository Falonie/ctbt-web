package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 敏感区域
 */
@Entity
@Table(name = "CONTROLAREA_TABLE")
@Getter
@Setter
//@ToString
public class SensitiveArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AREA_ID")
    private Integer areaId;

    @Column(name = "AREANAME")
    private String areaName;

    @Column(name = "PEOPLENAME")
    private String peopleName;

    @Column(name = "USERID")
    private Integer userId;

    @Column(name = "AREATIME")
    private Date areaTime;

    @Column(name = "AREAFUNCTION")
    private String areaFunction;

    @Column(name = "GEOMETRY")
    private String geometry;

    @ManyToMany
    @JoinTable(name = "AREAALARM_TABLE", joinColumns = @JoinColumn(name = "AREAID"),
            inverseJoinColumns = @JoinColumn(name = "SHIPID"))
    @JsonIgnore
    private List<Ships> shipsList2;

}
