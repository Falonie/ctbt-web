package com.ctbt.ctbtweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOG_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "LOGSEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATETIME")
    private Date date;

    @Column(name = "IPADDRESS")
    private String ipAddress;//操作的ip来源

    @Column(name = "MACADDRESS")
    private String macAddress;//操作的mac来源

    @Column(name = "TRUEADDRESS")
    private String trueAddress;//操作的真实地址来源

    @Column(name = "CLIENTTYPE")
    private String clientType;//表示它是哪一个终端
    /**
     * 用户0 船舶1 轨迹2 港区港口3 分组4 报警信息5 区域信息6 监控7
     */

    @Column(name = "TYPE")
    private String type;

    @Column(name = "OPERATIONTYPE")
    private String operationType;

    @Column(name = "CLASSNAME")
    private String className;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    private User user;
}
