package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.converter.AlarmAreaToAlarmAreaDetail;
import com.ctbt.ctbtweb.dto.AlarmAreaDetailDto;
import com.ctbt.ctbtweb.entity.Alarm;
import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Resource
    private AlarmAreaService alarmAreaService;
    @Resource
    private ShipsToAlarmAreaService shipsToAlarmAreaService;
    @Resource
    private ShipsService shipsService;
    @Resource
    private UserService userService;
    @Resource
    private AlarmService alarmService;

    /**
     * 显示当前用户的警戒区域
     *
     * @param page
     * @param size
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/alarmAreas")
    public ServerResponse alarmAreas(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "id", required = false) int id, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<AlarmArea> sensitiveAreaPage = null;
        if (user.getId() != 122) {
            sensitiveAreaPage = alarmAreaService.findSensitiveAreasByUserId(user.getId(), request);
        } else {
            sensitiveAreaPage = alarmAreaService.findSensitiveAreas(request);
        }
        List<AlarmAreaDetailDto> alarmAreaDetailDtoList = AlarmAreaToAlarmAreaDetail.convertList(sensitiveAreaPage.getContent());
        return ServerResponse.success(sensitiveAreaPage.getContent());
    }

    /**
     * 显示允许报警的船舶列表或不允许报警的船舶列表
     *
     * @param page
     * @param size
     * @param isAllowAlarm 是否允许报警，1为是，0为否
     * @param areaId       警戒区域id
     * @return
     */
    @GetMapping("/alarmAreas/list")
    public ServerResponse list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "isAllowAlarm") String isAllowAlarm,
                               @RequestParam("areaId") Integer areaId
//                               @RequestParam(value = "id", required = false) int id, HttpSession session
    ) {
        PageRequest request = PageRequest.of(page - 1, 10);
//        Page<Alarm> allowAlarmPage = alarmService.findAllByIsAllowAlarm(isAllowAlarm, request);
        Page<Alarm> allowAlarmPage = alarmService.findAllByAreaIdAndIsAllowAlarm(areaId, isAllowAlarm, request);
        return ServerResponse.success(allowAlarmPage.getContent());
    }

    /**
     * 添加船舶到允许报警或不允许报警的列表
     *
     * @param shipId       船舶id
     * @param areaId       警戒区域id
     * @param isAllowAlarm 是否允许报警，1为是，0为否
     * @param content      备注
     * @return 该警戒区域允许/不允许报警的船舶
     */
    @PostMapping("/alarmAreas/addShip")
    public ServerResponse add(@RequestParam("shipId") int shipId, @RequestParam("areaId") int areaId,
                              @RequestParam(value = "isAllowAlarm") String isAllowAlarm,
                              @RequestParam(value = "content", required = false) String content,
                              @RequestParam(value = "addReason",required = false) String addReason) {
        Ships ships = shipsService.findById(shipId);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        AlarmArea alarmArea = alarmAreaService.findByAreaIdOrAreaName(areaId, "");
        if (alarmArea == null) {
            return ServerResponse.failByMsg("该警戒区域不存在");
        }
        Alarm allowAlarm = alarmService.findByShipIdAndAreaIdAndIsAllowAlarm(shipId, areaId, "0");
        Alarm notAllowAlarm = alarmService.findByShipIdAndAreaIdAndIsAllowAlarm(shipId, areaId, "1");
        if (allowAlarm != null || notAllowAlarm != null) {
            return ServerResponse.failByMsg("该船已在列表中");
        }
        Alarm alarm = new Alarm();
        alarm.setShipId(ships.getId());
        alarm.setShipName(ships.getName());
        alarm.setProductId(ships.getProductId());
        alarm.setEquipmentId(ships.getEquipmentid());
        alarm.setIsAllowAlarm(isAllowAlarm);
        alarm.setContent(content);
        alarm.setAddReason(addReason);
        alarm.setCreateTime(new Date());
        alarm.setAreaId(areaId);
        Alarm result = alarmService.save(alarm);
        return ServerResponse.success(result);
    }

    /**
     * 删除该列表的该船舶
     *
     * @param id
     * @param shipId
     * @return
     */
    @DeleteMapping("/alarmAreas/delete")
    public ServerResponse delete(@RequestParam(value = "id", defaultValue = "0", required = false) int id,
                                 @RequestParam("shipId") int shipId) {
        Alarm alarm = alarmService.findByIdOrShipIdOrIsAllowAlarm(id, shipId, "");
        if (alarm == null) {
            return ServerResponse.failByMsg("找不到对象");
        }
        try {
            alarmService.delete(alarm);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
//            e.printStackTrace();
            return ServerResponse.successByMsg("删除失败");
        }
    }
}
