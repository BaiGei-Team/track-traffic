package com.track.traffic.rpc.impl;

import com.track.traffic.rpc.AlarmRpc;
import com.track.traffic.rpc.po.request.AlarmQueryRequest;
import com.track.traffic.rpc.po.vo.AlarmVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
    @Override
    public List<AlarmVO> queryAlarms(AlarmQueryRequest request) {
        return null;
    }
}
