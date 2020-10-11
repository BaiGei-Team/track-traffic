package com.track.traffic.rpc.po.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 16:18
 */
@Data
@Accessors(chain = true)
public class AlarmQueryRequest {
    /**
     * 网络或设备名称，为空查询所有
     */
    private String nodeName;
    /**
     * 节点类型
     *
     * @see com.track.traffic.rpc.enums.NodeTypeEnum
     */
    private String nodeType;
    private Integer perceivedSeverity;
    private String alarmType;
}
