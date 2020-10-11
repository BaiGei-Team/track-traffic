package com.track.traffic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.track.traffic")
public class TrackTrafficApplication {

    /**
     * 函数启动
     *
     * @param args 请求参数
     */
    public static void main(String[] args) {
        SpringApplication.run(TrackTrafficApplication.class, args);
    }

}
