package com.track.traffic.rpc.impl;

import com.track.traffic.rpc.PerformanceRpc;
import com.track.traffic.rpc.config.NetManageConfig;
import com.track.traffic.rpc.po.request.PerformanceDetailReq;
import com.track.traffic.rpc.po.request.PerformanceSumReq;
import com.track.traffic.rpc.po.response.PerformanceDetailResp;
import com.track.traffic.rpc.po.response.PerformanceSumResp;
import com.track.traffic.rpc.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:15
 */
@Slf4j
@Component
public class PerformanceRpcImpl implements PerformanceRpc {
    /**
     * 接口定义
     */
    public static final String GET_DETAIL_PERF = "getDatailPerfInfo.action";
    public static final String GET_SUM_PERF = "getSummaryPerfInfo.action";
    @Resource
    private NetManageConfig netManageConfig;

    @Override
    public PerformanceDetailResp getDetail(PerformanceDetailReq req) {
        return HttpClientUtils.post(netManageConfig.resolveUrl(GET_DETAIL_PERF),
                null,
                req,
                PerformanceDetailResp.class);
    }

    @Override
    public PerformanceSumResp getSum(PerformanceSumReq req) {
        return HttpClientUtils.post(netManageConfig.resolveUrl(GET_SUM_PERF),
                null,
                req,
                PerformanceSumResp.class);
    }
}
