package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROVINCE_TABLE", indexes = {@Index(columnList = "id")})
@Getter
@Setter
@ToString
public class Province {
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "NATIONID")
//    private int nationId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "province_seq")
    @SequenceGenerator(name = "province_seq", sequenceName = "PROVINCESEQ", allocationSize = 1)
    @Column(name = "PROVINCEID")
    private int provinceId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "NATIONID")
    private Nation nation;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> cityList;

    public Province() {
        super();
    }

    public Province(int id) {
        super();
        this.id = id;
    }
}
