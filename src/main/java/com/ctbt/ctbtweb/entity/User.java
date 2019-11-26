package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER_TABLE")
//@Data
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USERSSEQ", allocationSize = 1)
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

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Ships> shipsList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SHIPSTOUSERS_TABLE", joinColumns = @JoinColumn(name = "USERID"),
            inverseJoinColumns = @JoinColumn(name = "SHIPID"))
    @JsonIgnore
    private List<Ships> shipsList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Log> logList;

    public User(int id) {
        super();
        this.id = id;
    }
}
