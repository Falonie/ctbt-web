package com.ctbt.ctbtweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PUSHDATA_TABLE")
@Data
public class PushData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IPADDRESS")
    private String ipAddress;

    @Column(name = "PORT")
    private String port;

    @Column(name = "PUSHFIELD")
    private String pushField;//发送的数据字段，以;分隔存放

    @Column(name = "PUSHSTATE")
    private String pushState;//发送状态

    @Column(name = "ISCHANGED")
    private String isChanged;//是否更新

    @Column(name = "ISPUSHING")
    private String isPushing;//是否正在推送

    @Column(name = "STARTDATE")
    private Date startDate;//推送开始的时间

    @Column(name = "ENDDATE")
    private Date endDate;//推送终端或者结束的时间

    @Column(name = "SECRETKEY")
    private String secretKey;    //加密秘钥

    @Column(name = "PASSWORD")
    private String password;    //密码 用于维持链接

    public PushData() {
        super();
    }

    public PushData(int id) {
        super();
        this.id = id;
    }

    public PushData(String name, String ipAddress, String port,
                    String pushField, String pushState) {
        super();
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
        this.pushField = pushField;
        this.pushState = pushState;
        //this.isPushing = isPushing;
    }
}
