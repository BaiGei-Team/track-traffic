package com.track.traffic.rpc.po.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:16
 */
@Data
public class PerformanceDetailReq {
    /**
     * 资源主键，“73CF86B59E6AAF9393C4E943D358A472”
     */
    private String nodeResourceKey;
    /**
     * 监视器名称，多个监视器以逗号分隔，“网口输入输出带宽,网口输入输出流量”
     */
    private String actionNames;
    /**
     * 查询起始时间，“2017-05-25 10:02”
     */
    @JSONField(name = "begin_date")
    private String beginDate;
    /**
     * 查询终止时间，“2017-05-25 10:03”
     */
    @JSONField(name = "end_date")
    private String endDate;
}
