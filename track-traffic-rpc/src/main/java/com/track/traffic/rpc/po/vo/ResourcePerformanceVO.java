package com.track.traffic.rpc.po.vo;

import lombok.Data;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:18
 */
@Data
public class ResourcePerformanceVO {
    /** 设备显示名称, "squall123" */
    private String nodeDisplayName;
    /**  监控数据的单位, "Kb/s" */
    private String monitorDataUnit;
    /** 监控数据的值, 21 */
    private Double monitorValue;
    /** 资源类型, "网络接口" */
    private String resourceTypeName;
    /** 描述 */
    private String dataDesc;
    /** 设备名, "网络_192.168.1.115_161" */
    private String nodeName;
    /** "-6742188067132581678" */
    private String dbKey;
    /** "网口输入输出带宽" */
    private String actionName;
    /** "2017-05-25T10:02:04" */
    private String monitorTime;
    /** "Broadcom 802.11n 网络适配器"  */
    private String resourceName;
}
