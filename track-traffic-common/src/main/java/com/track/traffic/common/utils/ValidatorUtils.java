package com.track.traffic.common.utils;

import com.track.traffic.common.exception.BadArgumentException;

import java.util.Objects;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 13:01
 */
public class ValidatorUtils {

    /**
     * 检查非空
     *
     * @param param  请求参数
     * @param errMsg 错误消息
     */
    public static void checkNotNull(Object param, String errMsg) {
        if (Objects.isNull(param)) {
            throw new BadArgumentException(errMsg);
        }
    }
}
