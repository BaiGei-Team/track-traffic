package com.track.traffic.rpc.po.response;

import com.track.traffic.rpc.po.vo.ResourcePerformanceVO;
import com.track.traffic.rpc.po.vo.UnitDimensionVO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:23
 */
@Data
public class PerformanceDetailResp {
    /**
     * 性能数据
     */
    private List<ResourcePerformanceVO> tableData;
    /**
     * 统计数据
     */
    private Map<String, UnitDimensionVO> chartsData;

}
