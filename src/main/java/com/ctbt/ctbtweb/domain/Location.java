//package com.ctbt.ctbtweb.domain;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * 杞ㄨ抗琛�
// *
// * @author RD
// */
//@Entity
//@Table(name = "LOCATION_TABLE")
//@Data
//public class Location {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID")
//    private int id;
//
//    @Column(name = "LONGITUDE")
//    private double longitude;
//
//    @Column(name = "LATITUDE")
//    private double latitude;
//
//    @Column(name = "DIRECTION")
//    private double direction;
//
//    @JsonIgnore
//    @Column(name = "TEMPERATURE")
//    private double temperature;
//
//    @JsonIgnore
//    @Column(name = "BATTERYSTATE")
//
//    private double batteryState;
//    @JsonIgnore
//    @Column(name = "BATTERYWARN")
//    private String batteryWarn;
//
//    @Column(name = "POSITIONDATE")
//    private Date positionDate;
//
////    @JsonIgnore
////    @Column(name = "")
////    private String deviceId;
//
//    @JsonIgnore
//    @Column(name = "DEVICETYPE")
//    private String deviceType;
//
//    @Column(name = "LOCATIONTYPE")
//    private String locationType;
//
//    @JsonIgnore
//    @Column(name = "SPEED")
//    private Double speed;
//
//    @JsonIgnore
//    @Column(name = "STATE")
//    private String state;
//
//    @JsonIgnore
//    @Column(name = "BOWDIRECTION")
//    private Double bowDirection;
//
//    @JsonIgnore
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//    @JoinColumn(name = "SHIPS_ID", referencedColumnName = "ID")
//    private Ships ships;
//
//    public Location() {
//        super();
//        this.longitude = 0;
//        this.latitude = 0;
//        this.direction = 0.0;
//        this.bowDirection = 0.0;
//        this.positionDate = null;
//        this.locationType = "";
//        this.state = "开启";
//        this.speed = 0.0;
//    }
//
//    public Location(int id) {
//        super();
//        this.id = id;
//    }
//}
