package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 警戒区域
 */
@Entity
@Table(name = "CONTROLAREA_TABLE")
@Getter
@Setter
@ToString
public class AlarmArea {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areaAlarm")
//    @SequenceGenerator(name = "areaAlarm", sequenceName = "areaAlarmSeq", allocationSize = 1)
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

    @Column(name = "AREA_ALARM_TYPE")
    private String areaAlarmType;

    @Column(name = "AREA_TYPE")
    private String areaType;

    @Column(name = "AREA_FUNC")
    private String areaFunc;

    @Column(name = "VALIDITY")
    private String validity;

//    @ManyToMany(mappedBy = "sensitiveAreaList")
//    @JsonIgnore
//    private List<Ships> ships;

}
