package com.track.traffic.rpc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 16:56
 */
@Component
public class NetManageConfig {

    /**
     * 替换格式
     */
    public static final String ACTION_PATTERN = "{action}";

    /**
     * 地址: http://127.0.0.1:8090/sugarnmsweb/page/{action}?name=admin&password=admin
     * <p>
     * {action}替换接口
     */
    @Value("${net.manage.url}")
    private String urlPattern;

    /**
     * 解析URL
     *
     * @param action 接口
     * @return 结果
     */
    public String resolveUrl(String action) {
        return urlPattern.replace(ACTION_PATTERN, action);
    }

}
