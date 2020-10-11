package com.track.traffic.rpc.impl;

import com.track.traffic.common.utils.ValidatorUtils;
import com.track.traffic.rpc.AlarmRpc;
import com.track.traffic.rpc.config.NetManageConfig;
import com.track.traffic.rpc.po.request.AlarmQueryReq;
import com.track.traffic.rpc.po.request.HistoryAlarmQueryReq;
import com.track.traffic.rpc.po.response.AlarmQueryResp;
import com.track.traffic.rpc.po.response.HistoryAlarmQueryResp;
import com.track.traffic.rpc.po.vo.AlarmVO;
import com.track.traffic.rpc.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 16:16
 */
@Slf4j
@Component
public class AlarmRpcImpl implements AlarmRpc {
    /**
     * 接口定义
     */
    public static final String QUERY_ALARM = "queryAlarmByCondition.action";
    public static final String QUERY_HISTORY_ALARM = "queryHistoryAlarmByCondition.action";
    @Resource
    private NetManageConfig netManageConfig;

    @Override
    public List<AlarmVO> queryCurrentAlarms(AlarmQueryReq req) {
        // 执行查询
        AlarmQueryResp resp = HttpClientUtils.post(netManageConfig.resolveUrl(QUERY_ALARM),
                null,
                req,
                AlarmQueryResp.class);
        ValidatorUtils.checkNotNull(resp, "query alarm error, request=" + req + "resp=" + resp);
        return resp.getData();
    }

    @Override
    public List<AlarmVO> queryHistoryAlarms(HistoryAlarmQueryReq req) {
        // 执行查询
        HistoryAlarmQueryResp resp = HttpClientUtils.post(netManageConfig.resolveUrl(QUERY_HISTORY_ALARM),
                null,
                req,
                HistoryAlarmQueryResp.class);
        ValidatorUtils.checkNotNull(req, "query history alarm error, request=" + req + ", resp=" + resp);
        return resp.getData();
    }
}
