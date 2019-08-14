package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShipForm {
    private String nation;

//    @Column(name = "PROVINCE")
    private String province;

//    @Column(name = "CITY")
    private String city;

//    @Column(name = "COUNTY")
    private String county;

//    @Column(name = "NAME")
    private String name;

//    @Column(name = "BYNAME")
    private String byName;

//    @Column(name = "SHIPSNUMBER")
    private String number;

//    @Column(name = "CALLSIGN")
    private String callSign;

//    @Column(name = "MMSI")
    private String mmsi;

//    @Column(name = "IMO")
    private String imo;

//    @Column(name = "LONGITUDE")
    private double longitude;

//    @Column(name = "LATITUDE")
    private double latitude;

//    @Column(name = "SPEED")
    private double speed;

//    @Column(name = "SHIPLENGTH")
    private double shipLength;

//    @Column(name = "SHIPWIDTH")
    private double shipWidth;

//    @Column(name = "DRAUGHT")
    private double draught;

//    @Column(name = "SHIPTYPE")
    private String shipType;

//    @Column(name = "STATE")
    private String state;

//    @Column(name = "DIRECTION")
    private double direction;

//    @Column(name = "BOWDIRECTION")
    private double bowDirection;

//    @Column(name = "DESTINATION")
    private String destination;

//    @Column(name = "ARRIVEDATE")
    private Date arriveDate;

//    @Column(name = "LOCATIONDATE")
    private Date positionDate;

//    @Column(name = "AISTYPE")
    private String aisType;

//    @Column(name = "RECEIVEDATE")
    private Date receiveDate;

//    @Column(name = "POSITIONTYPE")
    private String positionType;

//    @Column(name = "EQUIPMENTID")
    private String equipmentid;

//    @Column(name = "PRODUCTID")
    private String productId;//产品Id

//    @Column(name = "ISUNPOWER")
    private String isUnpower;//是否无动力船舶

//    @Column(name = "UNPOWERLONGITUDE")
    private double unpowerLongitude;//无动力船舶经度

//    @Column(name = "UNPOWERLATITUDE")
    private double unpowerLatitude;//无动力船舶纬度

//    @Column(name = "RADIUS")
    private double radius;//无动力船舶半径

//    @Column(name = "ISUNPOWERVIEW")
    private String isUnPowerView;//表示是否利用显示

//    @Column(name = "OWNER")
    private String owner;//表示船主

//    @Column(name = "PHONENUMBER")
    private String phoneNumber;//表示船主联系方式

//    @Column(name = "TONS")
    private double tons;//表示吨位

//    @Column(name = "ISNEEDALARM")
    private String isNeedAlarm;    //30分钟未上报是否报警

//    @Column(name = "CLASSIFY")
    private String classify;    //船只

//    @Column(name = "IMAGEFILENAME")
    private String imageFileName;

//    @Column(name = "TOWNID")
    private Integer townId;

//    @Column(name = "VILLAGEID")
    private Integer villageId;

//    @Column(name = "STANDARDSHIPTYPE")
    private Integer standardShipType;

//    @Column(name = "CARDNO")
    private Integer cardNo;

}
