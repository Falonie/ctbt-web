package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
public class ShipForm {
    private String nation;

    private String province;

    private String city;

    private String county;

    @NotEmpty(message = "船名不能为空")
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

    @NotEmpty(message = "示位仪卡号不能为空")
    private String equipmentId;

//    产品Id
    @NotEmpty(message = "产品ID不能为空")
    @Size(min = 6, max = 6, message = "产品ID长度应为6位")
    @Pattern(regexp = "[A-Z]{2}\\d{4}", message = "产品ID长度应为6位，且前两位为大写字母，后4位为数字")
    private String productId;

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
