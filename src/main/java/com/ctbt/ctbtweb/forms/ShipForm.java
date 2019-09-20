package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ShipForm {
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

    private String productId;//产品Id

    private String isUnpower;//是否无动力船舶

    private double unpowerLongitude;//无动力船舶经度

    private double unpowerLatitude;//无动力船舶纬度

    private double radius;//无动力船舶半径

    private String isUnPowerView;//表示是否利用显示

    private String owner;//表示船主

    private String phoneNumber;//表示船主联系方式

    private double tons;//表示吨位

    private String isNeedAlarm;    //30分钟未上报是否报警

    private String classify;    //船只

    private String imageFileName;

    private Integer townId;

    private Integer villageId;

    private Integer standardShipType;

    private Integer cardNo;
}
