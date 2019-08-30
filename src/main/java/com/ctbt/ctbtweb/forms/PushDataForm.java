package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class PushDataForm {
    @NotEmpty(message = "名称不能为空")
    private String name;

    private String ipAddress;

    private String port;

    private String pushField;//发送的数据字段，以;分隔存放

    private String pushState;//发送状态

    private String isChanged;//是否更新

    private String isPushing;//是否正在推送

    private Date startDate;//推送开始的时间

    private Date endDate;//推送终端或者结束的时间

    private String secretKey;    //加密秘钥

    private String password;    //密码 用于维持链接
}
