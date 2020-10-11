package com.track.traffic.rpc;

import com.track.traffic.rpc.po.request.AlarmQueryReq;
import com.track.traffic.rpc.po.request.HistoryAlarmQueryReq;
import com.track.traffic.rpc.po.vo.AlarmVO;

import java.util.List;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 */
public interface AlarmRpc {

    /**
     * 查询当前告警列表
     *
     * @param req 请求对象
     * @return 结果
     */
    List<AlarmVO> queryCurrentAlarms(AlarmQueryReq req);

    /**
     * 查询历史告警列表
     *
     * @param req 请求对象
     * @return 结果
     */
    List<AlarmVO> queryHistoryAlarms(HistoryAlarmQueryReq req);
}
