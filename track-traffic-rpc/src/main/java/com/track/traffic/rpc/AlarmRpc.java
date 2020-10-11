package com.track.traffic.rpc;

import com.track.traffic.rpc.po.request.AlarmQueryRequest;
import com.track.traffic.rpc.po.vo.AlarmVO;

import java.util.List;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 */
public interface AlarmRpc {

    /**
     * 查询告警列表
     *
     * @param request 请求对象
     * @return 结果
     */
    List<AlarmVO> queryAlarms(AlarmQueryRequest request);
}
