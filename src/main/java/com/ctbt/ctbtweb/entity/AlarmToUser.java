package com.ctbt.ctbtweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ALARM_TO_USER")
@Data
public class AlarmToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer alarmRecordId;
    private Integer userId;
    private String userName;
    private Integer userType;
    private String processType;
    private Date processTime;
    private String processBy;
    private String processDescription;
}
