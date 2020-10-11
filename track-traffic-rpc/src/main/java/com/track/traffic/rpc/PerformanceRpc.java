package com.track.traffic.rpc;

import com.track.traffic.rpc.po.request.PerformanceDetailReq;
import com.track.traffic.rpc.po.request.PerformanceSumReq;
import com.track.traffic.rpc.po.response.PerformanceDetailResp;
import com.track.traffic.rpc.po.response.PerformanceSumResp;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 */
public interface PerformanceRpc {

    /**
     * 查询性能明细信息
     *
     * @param req 请求对象
     * @return 结果
     */
    PerformanceDetailResp getDetail(PerformanceDetailReq req);

    /**
     * 查询性能统计信息
     *
     * @param req 请求数据
     * @return 响应数据
     */
    PerformanceSumResp getSum(PerformanceSumReq req);
}
