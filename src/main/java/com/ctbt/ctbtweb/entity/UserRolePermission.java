package com.ctbt.ctbtweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CTBT_USER_ROLE_PERM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePermission {
    @EmbeddedId
    private UserRolePermissionId userRolePermissionId;
}
