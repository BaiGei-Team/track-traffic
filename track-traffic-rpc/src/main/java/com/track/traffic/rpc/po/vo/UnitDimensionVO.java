package com.track.traffic.rpc.po.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 17:21
 */
@Data
public class UnitDimensionVO {
    /**
     * 单位，KB，KB/s
     */
    private String unit;
    /**
     * 横坐标数据，2017-05-25T10:02:04，2017-05-25T10:02:04
     */
    private List<String> xData;
    /**
     * 纵坐标数据，21,22,23
     */
    private List<String> yData;
}
