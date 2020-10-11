package com.track.traffic.web.config;

import com.github.alenfive.rocketapi.datasource.DataSourceManager;
import com.github.alenfive.rocketapi.datasource.MySQLDataSource;
import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 8:20
 */
@Configuration
public class RocketApiConfig extends DataSourceManager {

    @Resource
    private DataSource dataSource;

    /**
     * 应用初始化
     */
    @PostConstruct
    public void init() {
        // 构造Jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // 放入工具类
        super.setDialectMap(ImmutableMap.of("mysql", new MySQLDataSource(jdbcTemplate, true)));
    }

}
