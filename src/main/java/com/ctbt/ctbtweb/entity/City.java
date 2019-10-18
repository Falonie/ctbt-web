package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY_TABLE")
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", sequenceName = "CITYSEQ", allocationSize = 1)
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

    public City(int id) {
        super();
        this.id = id;
    }
}
