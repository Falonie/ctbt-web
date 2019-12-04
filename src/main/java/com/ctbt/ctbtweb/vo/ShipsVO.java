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

    private String name;

    private String mmsi;

    private String shipType;

    private String equipmentId;

//    产品Id
    private String productId;

//    船主
    private String owner;

//    船主联系方式
    private String phoneNumber;

    private Integer cardNo;
}
