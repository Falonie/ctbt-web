package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ALARM_TO_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alarm_to_user_seq")
    @SequenceGenerator(name = "alarm_to_user_seq", sequenceName = "SEQ_ALARM_TO_USER_ID", allocationSize = 1)
    private Integer id;
    private Integer alarmRecordId;
    private Integer userId;
    private String userName;
    private Integer userType;
    private String processType;
    private Date processTime;
    private String processBy;
    private String processDescription;
    private Date createTime;
}
