package com.track.traffic.common.exception;

import com.track.traffic.common.errcode.ErrorCode;
import lombok.Getter;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 12:57
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private final ErrorCode errorCode;

    /**
     * 默认构造函数
     *
     * @param message 错误消息
     */
    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 默认构造函数
     *
     * @param errorCode 错误码
     * @param message   错误消息
     * @param cause     原因
     */
    public BaseException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
