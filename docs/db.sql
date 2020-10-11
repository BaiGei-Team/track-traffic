CREATE TABLE `api_info`
(
    `id`          varchar(45) NOT NULL,
    `method`      varchar(45)      DEFAULT NULL,
    `path`        varchar(100)     DEFAULT NULL,
    `type`        varchar(5)       DEFAULT NULL COMMENT '类型：CODE,SQL',
    `service`     varchar(45)      DEFAULT NULL,
    `group_name`  varchar(45)      DEFAULT NULL,
    `editor`      varchar(45)      DEFAULT NULL,
    `name`        varchar(200)     DEFAULT NULL,
    `datasource`  varchar(45)      DEFAULT NULL,
    `script`      text,
    `options`     text,
    `create_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_path_method` (`service`, `path`, `method`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='路径明细';

CREATE TABLE `api_info_history`
(
    `id`          varchar(45) NOT NULL,
    `api_info_id` varchar(45) NOT NULL,
    `method`      varchar(45)      DEFAULT NULL,
    `path`        varchar(100)     DEFAULT NULL,
    `type`        varchar(5)       DEFAULT NULL COMMENT '类型：CODE,SQL',
    `service`     varchar(45)      DEFAULT NULL,
    `group_name`  varchar(45)      DEFAULT NULL,
    `editor`      varchar(45)      DEFAULT NULL,
    `name`        varchar(200)     DEFAULT NULL,
    `datasource`  varchar(45)      DEFAULT NULL,
    `script`      text,
    `options`     text,
    `create_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP,
    `elapsed_time`    datetime null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='路径明细历史';

CREATE TABLE `api_example`
(
    `id`              varchar(45) NOT NULL,
    `api_info_id`     varchar(45) NOT NULL,
    `method`          varchar(45) DEFAULT NULL,
    `url`             text,
    `request_header`  text,
    `request_body`    text,
    `response_header` text,
    `response_body`   text,
    `status`          varchar(10) DEFAULT NULL,
    `time`            int(11)     DEFAULT NULL,
    `options`         text,
    `editor`          varchar(45) DEFAULT NULL,
    `create_time`     datetime    DEFAULT NULL,
    `elapsed_time`    datetime null,
    PRIMARY KEY (`id`),
    KEY `index_api_id` (`api_info_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='模拟数据';
