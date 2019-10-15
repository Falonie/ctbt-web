package com.ctbt.ctbtweb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CTBT_USER_ROLE")
@Data
public class RoleToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq", sequenceName = "SEQ_USER_ROLE_ID", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "ROLEID")
    private int roleId;
}
