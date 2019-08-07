package com.ctbt.ctbtweb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY_TABLE")
//@Data
@Getter
@Setter
//@ToString
public class City {

    public City() {
        super();
    }

    public City(int id) {
        super();
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CITYID")
    private int cityId;

    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "PROVINCEID")
//    private int provinceId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "PROVINCEID")
    private Province province;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<County> countyList;
}
