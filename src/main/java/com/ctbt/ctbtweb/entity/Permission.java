package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CTBT_PERM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
    @SequenceGenerator(name = "permission_seq", sequenceName = "SEQ_PERM_ID", allocationSize = 1)
    private int permId;
    private int parentId;
    private int permLevel;
    private String permName;
    private String permType;
    private String permUrl;
    private String permIcon;
    private String orderNo;
    private String validity;
    private String permScript;
}
