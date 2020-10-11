package com.track.traffic.rpc.po.request;

import lombok.Data;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:35
 */
@Data
public class HistoryAlarmQueryReq {
    /**
     * 要查询的网络名或设备名，为空时代表全网查询，“网络_192.168.1.123_161”
     */
    private String nodeName;
    /**
     * 表示要查询的是网络还是设备，为“NodeDevice”代表设备，为”NetWork”代表网 络，”NodeDevice”
     *
     * @see com.track.traffic.rpc.enums.NodeTypeEnum
     */
    private String nodeType;
    /**
     * 告警级别，8—掉线,7—严重,6—主要,5—次要,3—未知， 7,5
     *
     * @see com.track.traffic.rpc.enums.AlarmLevelEnum
     */
    private Integer perceivedSeverity;
    /**
     * 告警类型，多个以逗号分隔，”CPU 负载,磁盘空间利用率”
     *
     * @see com.track.traffic.rpc.enums.AlarmTypeEnum
     */
    private String alarmType;
    /**
     * 开始日期 2017-05-25 16:40
     */
    private String beginDate;
    /**
     * 结束日期：2017-5-25 17:10
     */
    private String endDate;
}
