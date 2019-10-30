package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 船舶表
 */
@Entity
@Table(name = "SHIPS_TABLE")
//@Data
@Getter
@Setter
@ToString
public class Ships {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ships_seq")
    @SequenceGenerator(name = "ships_seq", sequenceName = "SHIPSSEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NATION")
    private String nation;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTY")
    private String county;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BYNAME")
    private String byName;

    @Column(name = "SHIPSNUMBER")
    private String number;

    @Column(name = "CALLSIGN")
    private String callSign;

    @Column(name = "MMSI")
    private String mmsi;

    @Column(name = "IMO")
    private String imo;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "SPEED")
    private double speed;

    @Column(name = "SHIPLENGTH")
    private double shipLength;

    @Column(name = "SHIPWIDTH")
    private double shipWidth;

    @Column(name = "DRAUGHT")
    private double draught;

    @Column(name = "SHIPTYPE")
    private String shipType;

    @Column(name = "STATE")
    private String state;

    @Column(name = "DIRECTION")
    private double direction;

    @Column(name = "BOWDIRECTION")
    private double bowDirection;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "ARRIVEDATE")
    private Date arriveDate;

    @Column(name = "LOCATIONDATE")
    private Date positionDate;

    @Column(name = "AISTYPE")
    private String aisType;

    @Column(name = "RECEIVEDATE")
    private Date receiveDate;

    @Column(name = "POSITIONTYPE")
    private String positionType;

    @Column(name = "EQUIPMENTID")
    private String equipmentId;

    @Column(name = "PRODUCTID")
    private String productId;//产品Id

    @Column(name = "ISUNPOWER")
    private String isUnpower;//是否无动力船舶

    @Column(name = "UNPOWERLONGITUDE")
    private double unpowerLongitude;//无动力船舶经度

    @Column(name = "UNPOWERLATITUDE")
    private double unpowerLatitude;//无动力船舶纬度

    @Column(name = "RADIUS")
    private double radius;//无动力船舶半径

    @Column(name = "ISUNPOWERVIEW")
    private String isUnPowerView;//表示是否利用显示

    @Column(name = "OWNER")
    private String owner;//表示船主

    @Column(name = "PHONENUMBER")
    private String phoneNumber;//表示船主联系方式

    @Column(name = "TONS")
    private double tons;//表示吨位

    @Column(name = "ISNEEDALARM")
    private String isNeedAlarm;    //30分钟未上报是否报警

    @Column(name = "CLASSIFY")
    private String classify;    //船只

    @Column(name = "IMAGEFILENAME")
    private String imageFileName;

    @Column(name = "TOWNID")
    private Integer townId;

    @Column(name = "VILLAGEID")
    private Integer villageId;

    @Column(name = "STANDARDSHIPTYPE")
    private Integer standardShipType;

    @Column(name = "CARDNO")
    private Integer cardNo;

    @OneToMany(mappedBy = "ships", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ShipsDevice> deviceList;

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//    @JoinColumn(name = "SHIPS_ID", referencedColumnName = "ID")
//    private User user;

    @ManyToMany(mappedBy = "shipsList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> userList;

    @OneToMany(mappedBy = "ships",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AlarmRecord> alarmRecordList;

//    @ManyToMany
//    @JoinTable(name = "SHIPSTOALARMAREA_TABLE", joinColumns = @JoinColumn(name = "SHIPID"),
//            inverseJoinColumns = @JoinColumn(name = "AREAID"))
//    @JsonIgnore
//    private List<AlarmArea> sensitiveAreaList;

    public Ships(int id) {
        super();
        this.id = id;
    }

    public Ships() {
        super();
        this.number = "";
        this.name = "";
        this.longitude = 0.0;
        this.latitude = 0.0;
        this.speed = 0.0;
        this.callSign = "";
        this.mmsi = "";
        this.shipLength = 0.0;
        this.shipWidth = 0.0;
        this.draught = 0.0;
        this.shipType = "";
        this.state = "";
        this.direction = 0.0;
        this.destination = "";
        this.arriveDate = null;
        this.positionDate = null;
        this.city = null;
        this.nation = "";
        this.province = "";
        this.county = "";
        this.imo = "";
        this.aisType = "";
        this.bowDirection = 0.0;
        this.receiveDate = null;
        this.equipmentId = "";
        this.byName = "";
        this.productId = "";
    }

    public Ships(int id, String name, String mmsi, Date positionDate) {
        super();
        this.id = id;
        this.name = name;
        this.mmsi = mmsi;
        this.positionDate = positionDate;
    }

    public Ships(int id, String name, String mmsi, String equipmentId, String productId, String owner, String phoneNumber) {
        super();
        this.id = id;
        this.name = name;
        this.mmsi = mmsi;
        this.equipmentId = equipmentId;
        this.productId = productId;
        this.owner = owner;
        this.phoneNumber = phoneNumber;
    }

    public Ships(int id, double longitude, double latitude, Date positionDate, double direction) {
        super();
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.positionDate = positionDate;
        this.direction = direction;
    }

    public Ships(int id, String mmsi, double longitude, double latitude, Date positionDate, double direction, String state) {
        super();
        this.id = id;
        this.mmsi = mmsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.positionDate = positionDate;
        this.direction = direction;
        this.state = state;
    }
}
