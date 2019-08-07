package com.ctbt.ctbtweb.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_TABLE")
//@Data
@Getter
@Setter
@ToString
public class User {

    public User() {
        super();
    }

    public User(int id) {
        super();
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TYPE")
    private int type;

    @Column(name = "CREATE_BY")
    private Integer createBy;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "USER_LEVEL")
    private int userLevel;

}
