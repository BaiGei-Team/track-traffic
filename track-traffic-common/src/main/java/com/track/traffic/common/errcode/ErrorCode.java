package com.track.traffic.common.errcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 12:58
 */
@AllArgsConstructor
@Getter
public enum ErrorCode {
    SUCCESS("00"),
    SYSTEM_ERROR("-1"),
    ARGUMENT_CHECK_ERROR("-2"),
    DB_EXECUTE_ERROR("-3");

    /**
     * 错误码定义
     */
    private final String code;
}
