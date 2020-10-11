package com.track.traffic.web.config;

import com.github.alenfive.rocketapi.extend.IResultWrapper;
import com.track.traffic.common.errcode.ErrorCode;
import com.track.traffic.domain.RpcResult;
import com.track.traffic.web.enums.RocketResultCode;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 12:50
 */
@Primary
@Component
public class ResultWrapperConfig implements IResultWrapper {
    @Override
    public Object wrapper(String code, String msg, Object data, HttpServletRequest request, HttpServletResponse response) {
        if (RocketResultCode.OK.is(code)) {
            return RpcResult.success(data);
        } else {
            return RpcResult.fail(ErrorCode.DB_EXECUTE_ERROR, msg);
        }
    }
}
