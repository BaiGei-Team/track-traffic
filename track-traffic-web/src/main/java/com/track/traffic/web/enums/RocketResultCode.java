package com.track.traffic.web.enums;

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
public enum RocketResultCode {
    OK("0"),
    FAIL("500");
    /**
     * RocketApi返回的代码
     */
    private final String code;

    /**
     * 判断是否相等
     *
     * @param code 错误码
     * @return 结果
     */
    public boolean is(String code) {
        return Objects.equals(this.code, code);
    }
}
