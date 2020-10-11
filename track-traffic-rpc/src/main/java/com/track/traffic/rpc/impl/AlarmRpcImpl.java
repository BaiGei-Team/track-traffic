package com.track.traffic.rpc.impl;

import com.track.traffic.common.utils.ValidatorUtils;
import com.track.traffic.rpc.AlarmRpc;
import com.track.traffic.rpc.config.NetManageConfig;
import com.track.traffic.rpc.po.request.AlarmQueryRequest;
import com.track.traffic.rpc.po.response.AlarmQueryResp;
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
    @Resource
    private NetManageConfig netManageConfig;

    @Override
    public List<AlarmVO> queryAlarms(AlarmQueryRequest request) {
        // 执行查询
        AlarmQueryResp resp = HttpClientUtils.post(netManageConfig.resolveUrl(QUERY_ALARM),
                null,
                request,
                AlarmQueryResp.class);
        ValidatorUtils.checkNotNull(resp, "query alarm error, request=" + request + "resp=" + resp);
        return resp.getData();
    }
}
