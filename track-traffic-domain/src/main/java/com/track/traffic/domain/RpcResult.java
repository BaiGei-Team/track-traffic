package com.track.traffic.domain;

import com.track.traffic.common.errcode.ErrorCode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 12:52
 */
@Data
@Accessors(chain = true)
public class RpcResult<T> implements Serializable {
    /**
     * 响应状态：true-成功，false-失败
     */
    private Boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 提示消息
     */
    private String message;
    /**
     * 返回结果
     */
    private T data;

    /**
     * 成功返回
     *
     * @param data 对象
     * @param <T>  参数
     * @return 结果
     */
    public static <T> RpcResult<T> success(T data) {
        return new RpcResult<T>()
                .setSuccess(true)
                .setCode(ErrorCode.SUCCESS.getCode())
                .setMessage("success")
                .setData(data);
    }

    /**
     * 错误响应
     *
     * @param errorCode 错误码
     * @param message   消息
     * @param <T>       类型
     * @return 结果
     */
    public static <T> RpcResult<T> fail(ErrorCode errorCode, String message) {
        // 保证错误码非空
        if (Objects.isNull(errorCode)) {
            errorCode = ErrorCode.SYSTEM_ERROR;
        }
        // 构造响应结果
        return new RpcResult<T>()
                .setSuccess(false)
                .setCode(errorCode.getCode())
                .setMessage(message);
    }

}
