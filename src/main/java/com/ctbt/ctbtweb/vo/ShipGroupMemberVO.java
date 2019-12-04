package com.ctbt.ctbtweb.vo;

import com.ctbt.ctbtweb.entity.Ships;
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
