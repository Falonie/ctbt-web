package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ShipTeamForm {
    @NotNull(message = "编组名不能为空")
    private String teamName;
    @NotNull(message = "船舶ID不能为空")
    private int teamLeaderShipId;
    @NotNull(message = "安全距离不能为空")
    private int safeDistance;
}
