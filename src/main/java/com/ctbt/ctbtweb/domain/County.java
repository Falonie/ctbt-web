package com.ctbt.ctbtweb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTY_TABLE")
//@Data
@Getter
@Setter
public class County {

    public County() {
        super();
    }

    public County(int id) {
        super();
        this.id = id;
    }

    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "CITYID")
//    private int cityId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COUNTYID")
    private int countyId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "CITYID")
    private City city;

    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Town> townList;

}
