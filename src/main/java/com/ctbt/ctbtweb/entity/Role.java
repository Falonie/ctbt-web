package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CTBT_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "SEQ_ROLE_ID", allocationSize = 1)
    @Column(name = "ROLE_ID")
    private int id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "ROLE_DESC")
    private String roleDesc;

    @Column(name = "VALIDITY")
    private String validity;

    public Role(String roleName, String roleDesc, String validity) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.validity = validity;
    }
}
