package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "SHIPS_DEVICE")
//@Data
@Getter
@Setter
//@ToString
public class ShipsDevice {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ships_device_seq")
    @SequenceGenerator(name = "ships_device_seq", sequenceName = "SEQ_SHIPSDEVICEID", allocationSize = 1)
    @Column(name = "DEV_ID")
    private Integer devId;

//    private Integer shipsId;

    @Column(name = "DEVICE_TYPE")
    private String deviceType;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "DEVICE_COMMENT")
    private String deviceComment;

    @Column(name = "VALIDITY")
    private String validity;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "SHIPS_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Ships ships;

    public ShipsDevice() {
        super();
    }
}
