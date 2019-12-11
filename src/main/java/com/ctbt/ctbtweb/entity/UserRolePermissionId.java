package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePermissionId implements Serializable {
    private int urId;

    private int permId;

    private String permType;
}
