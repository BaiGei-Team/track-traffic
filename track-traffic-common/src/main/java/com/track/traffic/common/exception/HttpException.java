package com.track.traffic.common.exception;

import com.track.traffic.common.errcode.ErrorCode;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 15:45
 */
public class HttpException extends BusinessException {
    /**
     * 默认构造函数
     *
     * @param message 错误消息
     */
    public HttpException(String message) {
        super(ErrorCode.SYSTEM_ERROR, message);
    }

    /**
     * 异常透传
     *
     * @param message 错误消息
     * @param cause   原因
     */
    public HttpException(String message, Throwable cause) {
        super(ErrorCode.SYSTEM_ERROR, message, cause);
    }
}
