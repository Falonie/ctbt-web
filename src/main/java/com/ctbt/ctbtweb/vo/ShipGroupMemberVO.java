package com.ctbt.ctbtweb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipGroupMemberVO {
    private ShipsVO shipsVO;

    private int shipGroupId;

    private String workStatus;
}
