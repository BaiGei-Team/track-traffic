package com.track.traffic.common.exception;

import com.track.traffic.common.errcode.ErrorCode;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 13:00
 */
public class BadArgumentException extends BusinessException {
    /**
     * 默认构造函数
     *
     * @param message 错误消息
     */
    public BadArgumentException(String message) {
        super(ErrorCode.ARGUMENT_CHECK_ERROR, message);
    }
}
