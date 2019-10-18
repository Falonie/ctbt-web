package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTY_TABLE")
@Data
@NoArgsConstructor
public class County {
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "CITYID")
//    private int cityId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "county_seq")
    @SequenceGenerator(name = "county_seq", sequenceName = "COUNTYSEQ", allocationSize = 1)
    @Column(name = "COUNTYID")
    private int countyId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "CITYID")
    private City city;

    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Town> townList;

    public County(int id) {
        super();
        this.id = id;
    }
}
