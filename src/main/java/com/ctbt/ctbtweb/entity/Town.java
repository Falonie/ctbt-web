package com.ctbt.ctbtweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TOWN_TABLE")
@Data
@NoArgsConstructor
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "town_seq")
    @SequenceGenerator(name = "town_seq", sequenceName = "TOWNSEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "COUNTYID")
//    private int countyId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "COUNTYID")
    private County county;

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Village> villages;
}
