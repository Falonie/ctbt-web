package com.ctbt.ctbtweb.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ShipsVO {
    private int id;

    private String nation;

    private String province;

    private String city;

    private String county;

    private String name;

    private String byName;

    private String number;

    private String callSign;

    private String mmsi;

    private String imo;

    private double longitude;

    private double latitude;

    private double speed;

    private double shipLength;

    private double shipWidth;

    private double draught;

    private String shipType;

    private String state;

    private double direction;

    private double bowDirection;

    private String destination;

    private Date arriveDate;

    private Date positionDate;

    private String aisType;

    private Date receiveDate;

    private String positionType;

    private String equipmentId;

//    产品Id
    private String productId;

//    是否无动力船舶
    private String isUnpower;

//    无动力船舶经度
    private double unpowerLongitude;

//    无动力船舶纬度
    private double unpowerLatitude;

//    无动力船舶半径
    private double radius;

//    表示是否利用显示
    private String isUnPowerView;

//    船主
    private String owner;

//    船主联系方式
    private String phoneNumber;

//    表示吨位
    private double tons;

//    30分钟未上报是否报警
    private String isNeedAlarm;

//    船只
    private String classify;

    private String imageFileName;

    private Integer townId;

    private Integer villageId;

    private Integer standardShipType;

    private Integer cardNo;

}
