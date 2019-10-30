package com.ctbt.ctbtweb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 船舶报警记录
 */
@Entity
@Table(name = "ALARM_RECORD")
//@Data
@Getter
@Setter
@ToString
public class AlarmRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alarm_record_seq")
    @SequenceGenerator(name = "alarm_record_seq", sequenceName = "SEQ_ALARM_RECORD_ID", allocationSize = 1)
    @Column(name = "ALARM_RECORD_ID")
    private Integer alarmRecordId;

    @Column(name = "ALARM_ID")
    private Integer alarmId;

    @Column(name = "time")
    private Date time;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "SHIPSID", referencedColumnName = "ID")
    private Ships ships;

//	private Integer shipsId;

//    private AlarmType alarmType;

//    private String alarmTypeId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "content")
    private String content;

    @Column(name = "LOCATIONTYPE")
    private String locationType;

    @Column(name = "EQUIPMENTID")
    private String equipmentId;

    @Column(name = "state")
    private String state;

    @Column(name = "PROCESSSTATUS")
    private String processStatus;

    @Column(name = "PROCESSTIME")
    private Date processTime;

    @Column(name = "PROCESSUSENAME")
    private String processUseName;

    @Column(name = "PROCESSTYPE")
    private String processType;

    @Column(name = "AREANAME")
    private String areaName;

    @Column(name = "PROCESSDES")
    private String processDes;

    @Column(name = "SHIPTYPE")
    private String shipType;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "DIRECTION")
    private double direction;

    @Column(name = "SPEED")
    private double Speed;

    @Column(name = "TEMPERATURE")
    private double temperature;

    @Column(name = "BATTERYSTATE")
    private double batteryState;

    @Column(name = "BATTERYWARN")
    private String batteryWarn;

    @Column(name = "ISSENDED")
    private String isSended;

    @Column(name = "HANDLEHISTORY")
    private String handleHistory;

    @Column(name = "HANDLESTATUS")
    private String handleStatus;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "DEVICE_TYPE")
    private String deviceType;

    @Column(name = "IS_ERROR")
    private String isError;

//    private List<AlarmToUser> alarmToUserList;

}
