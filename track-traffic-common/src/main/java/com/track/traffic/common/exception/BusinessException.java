package com.track.traffic.common.exception;

import com.track.traffic.common.errcode.ErrorCode;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 13:00
 */
public class BusinessException extends BaseException {
    /**
     * 默认构造函数
     *
     * @param errorCode 错误码
     * @param message   错误消息
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
