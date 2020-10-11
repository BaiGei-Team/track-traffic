package com.track.traffic.rpc.po.vo;

import lombok.Data;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 16:25
 */
@Data
public class AlarmVO {
    /** 确认告警用户，"" */
    private String ackManagerUser;
    /** 监控值的单位，"" */
    private String monitorDataUnit;
    /** 当前状态，分为"工作状态"和"Trap 工作状态",  "工作状态" */
    private String currentStatusType;
    /** 网络名称，"网络" */
    private String groupName;
    /** 告警内容，"监控数据:95" */
    private String alarmContent;
    /** 告警是否被清除，分为”已清除”和”未清除”，"未清除" */
    private String clearStats;
    /** 告警确认时间，"" */
    private String ackTimes;
    /** 告警最新的更新时间，"2017-05-26 10:24:00" */
    private String lastUpdateTime;
    /** 设备名称，"网络_192.168.1.123_161" */
    private String nodeName;
    /** 告警产生的时间， "2017-05-25 11:47:09" */
    private String ceateTime;
    /** 最新监控值，"95" */
    private String lastMonitorValue;
    /** 当前告警主键，"8B7137E498A00CD5FFB0C5478F225C28" */
    private String id;
    /** 告警类型，"磁盘空间利用率" */
    private String typeName;
    /** 确认告警状态，"否" */
    private String confirmStatus;
    /** 告警资源的主键，"10893C2CF04FE8DD36284C2DA8DD5363" */
    private String nodeResourceKey;
    /** 资源类型，"磁盘" */
    private String resourceTypeName;
    /** 告警原因，"磁盘空间不足" */
    private String alarmReason;
    /**
     * 告警级别，7
     *
     * @see com.track.traffic.rpc.enums.AlarmLevelEnum
     */
    private String perceivedSeverity;
    /** 清除时间，"2017-05-26 10:24:00" */
    private String clearStatsTime;
    /** 设备类型，"SNMP_Windows" */
    private String nodeType;
    /** 清除告警用户，"" */
    private String clearManagerUser;
    /** 资源名称，"E:\\ Label:RECOVERY  Serial Number ae8de631" */
    private String resourceName;
    /** 设备 IP 地址， "192.168.1.123" */
    private String ipAddress;
    /**  设备显示名称，"LAPTOP"  */
    private String nodeDisName;
}
