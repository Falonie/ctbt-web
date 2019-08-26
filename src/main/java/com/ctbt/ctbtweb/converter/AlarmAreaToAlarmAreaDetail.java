package com.ctbt.ctbtweb.converter;

import com.ctbt.ctbtweb.dto.AlarmAreaDetailDto;
import com.ctbt.ctbtweb.entity.AlarmArea;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AlarmAreaToAlarmAreaDetail {
    private static AlarmAreaDetailDto convertDTO(AlarmArea alarmArea) {
        AlarmAreaDetailDto alarmAreaDetailDto = new AlarmAreaDetailDto();
        BeanUtils.copyProperties(alarmArea, alarmAreaDetailDto);
        return alarmAreaDetailDto;
    }

    public static List<AlarmAreaDetailDto> convertList(List<AlarmArea> alarmAreaList) {
        return alarmAreaList.stream().map(AlarmAreaToAlarmAreaDetail::convertDTO).collect(Collectors.toList());
    }
}

