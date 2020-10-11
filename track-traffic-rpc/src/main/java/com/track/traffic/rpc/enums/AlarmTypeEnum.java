package com.track.traffic.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:37
 */
@AllArgsConstructor
@Getter
public enum AlarmTypeEnum {
    CPU_USAGE("CPU 负载"),
    DESK_USAGE("磁盘空间利用率"),
    ;
    /**
     * 代码定义
     */
    private final String code;
}
