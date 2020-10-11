package com.track.traffic.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 */
@AllArgsConstructor
@Getter
public enum NodeTypeEnum {
    /**
     * 设备
     */
    Device("NodeDevice"),
    /**
     * 网络
     */
    NetWork("NetWork");
    /**
     * 类型代码
     */
    private final String type;
}
