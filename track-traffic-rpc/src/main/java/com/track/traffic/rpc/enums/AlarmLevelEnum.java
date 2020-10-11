package com.track.traffic.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 */
@AllArgsConstructor
@Getter
public enum AlarmLevelEnum {
    /**
     * 离线
     */
    Offline(8),
    /**
     * 严重
     */
    Serious(7),
    /**
     * 主要
     */
    Main(6),
    /*
     * 次要
     */
    Minor(5),
    /**
     * 未知
     */
    Unknown(3),
    /**
     * 正常
     */
    Online(1),
    ;
    /**
     * 级别代码
     */
    private final Integer code;

    /**
     * 判断是否相等
     *
     * @param code 代码
     * @return 结果
     */
    public boolean is(Integer code) {
        return Objects.equals(this.code, code);
    }
}
