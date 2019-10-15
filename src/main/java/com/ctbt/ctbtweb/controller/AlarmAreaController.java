package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.entity.ShipsToAlarmArea;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.service.ShipsToAlarmAreaService;
import com.ctbt.ctbtweb.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/alarmArea")
public class AlarmAreaController {
    @Resource
    private AlarmAreaService alarmAreaService;
    @Resource
    private ShipsToAlarmAreaService shipsToAlarmAreaService;
    @Resource
    private ShipsService shipsService;
    @Resource
    private UserService userService;

    @GetMapping("/listAll")
    public ServerResponse allSensitiveAreaService(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<AlarmArea> sensitiveAreaPage = alarmAreaService.findSensitiveAreas(request);
        return ServerResponse.success(sensitiveAreaPage.getContent());
    }

//    @GetMapping("/list")
//    public ServerResponse sensitiveAreaServiceByUserId(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                                       @RequestParam(value = "size", defaultValue = "10") Integer size,
//                                                       @RequestParam(value = "id", required = false) int id, HttpSession session) {
////        User user = (User) session.getAttribute(Constant.CURRENT_USER);
////        if (user == null) {
////            return ServerResponse.failByMsg("请先登录");
////        }
//        User user = userService.findById(id);
//        if (user == null) {
//            return ServerResponse.failByMsg("该用户不存在");
//        }
//        PageRequest request = PageRequest.of(page - 1, 10);
//        Page<AlarmArea> sensitiveAreaPage = null;
//        if (user.getId() != 122) {
//            sensitiveAreaPage = alarmAreaService.findSensitiveAreasByUserId(user.getId(), request);
//        } else {
//            sensitiveAreaPage = alarmAreaService.findSensitiveAreas(request);
//        }
//        return ServerResponse.success(sensitiveAreaPage.getContent());
//    }

    /**
     * 绑定船舶至警戒区域
     *
     * @param shipId
     * @param sensitiveAreaId
     * @return
     */
    @PostMapping("/addShipToAlarmArea")
    public ServerResponse addShipToAlarmArea(@RequestParam("shipId") int shipId,
                                             @RequestParam("sensitiveAreaId") int sensitiveAreaId) {
        ShipsToAlarmArea shipsToAlarmArea = new ShipsToAlarmArea();
        if (shipsService.findById(shipId) == null || alarmAreaService.findByAreaIdOrAreaName(sensitiveAreaId, "") == null) {
            return ServerResponse.failByMsg("该船舶或警戒区域不存在");
        }
        shipsToAlarmArea.setShipId(shipId);
        shipsToAlarmArea.setAreaId(sensitiveAreaId);
        ShipsToAlarmArea result = shipsToAlarmAreaService.save(shipsToAlarmArea);
        if (result == null) {
            return ServerResponse.failByMsg("绑定失败");
        }
        return ServerResponse.success("绑定成功", result);
    }

    @GetMapping("/listShiptoAlarmArea")
    public ServerResponse listShipToAlarmArea(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 20);
        Page<ShipsToAlarmArea> shipsToAlarmAreaPage = shipsToAlarmAreaService.findAll(request);
        return ServerResponse.success(shipsToAlarmAreaPage.getContent());
//        List<AlarmArea> sensitiveAreaList = shipsToAlarmAreaPage.getContent().stream().map(e -> alarmAreaService.findByAreaId(e.getAreaId())).collect(Collectors.toList());
//        return ServerResponse.success(sensitiveAreaList);
    }
}
