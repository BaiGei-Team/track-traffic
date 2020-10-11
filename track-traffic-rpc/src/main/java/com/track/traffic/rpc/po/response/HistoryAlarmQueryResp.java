package com.track.traffic.rpc.po.response;

import com.track.traffic.rpc.po.vo.AlarmVO;
import lombok.Data;

import java.util.List;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:40
 */
@Data
public class HistoryAlarmQueryResp {
    private List<AlarmVO> data;
}
