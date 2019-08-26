package com.ctbt.ctbtweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ALLOW_ALARM")
@Getter
@Setter
@NoArgsConstructor
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int shipId;

    private String shipName;

    private String productId;

    private String equipmentId;

    private int areaId;

    private String isAllowAlarm;

    private String content;

    private String addReason;

    private Date createTime;
}
