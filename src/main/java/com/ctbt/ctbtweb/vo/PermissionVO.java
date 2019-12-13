package com.ctbt.ctbtweb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionVO {
    private int permId;
    private int parentId;
    private int permLevel;
    private String permName;
    private String permType;
}
