package com.ctbt.ctbtweb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BindShipRequest {
    public int shipId;
    public int userId;
}
