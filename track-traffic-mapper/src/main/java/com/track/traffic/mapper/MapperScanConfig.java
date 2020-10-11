package com.track.traffic.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 8:25
 */
@Component
@MapperScan("com.track.traffic.mapper")
public class MapperScanConfig {
}
