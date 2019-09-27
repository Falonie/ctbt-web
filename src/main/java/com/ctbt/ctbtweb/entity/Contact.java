package com.ctbt.ctbtweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_TABLE")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEL")
    private String tel;
    //private int type;

    @Column(name = "SENDFIELD")
    private String sendField;//发送的数据字段，以;分隔存放

    @Column(name = "SENDSTATE")
    private String sendState;//发送状态


    public Contact(String name, String tel) {
        super();
        this.name = name;
        this.tel = tel;
    }


    public Contact(String name, String tel, String sendField, String sendState) {
        super();
        this.name = name;
        this.tel = tel;
        this.sendField = sendField;
        this.sendState = sendState;
    }
}
