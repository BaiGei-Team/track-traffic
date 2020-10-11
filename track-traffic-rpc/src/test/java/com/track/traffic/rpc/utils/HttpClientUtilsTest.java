package com.track.traffic.rpc.utils;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HttpClientUtilsTest {

    @Test
    public void get() {
        String resp = HttpClientUtils.get("http://www.baidu.com");
        System.out.println(resp);
        assertNotNull(resp);
    }

    @Test
    public void post() {
        String resp = HttpClientUtils.post("http://www.baidu.com", ImmutableMap.<String, String>builder()
                        .put("a", "123")
                        .build(),
                "asdf",
                String.class);
        System.out.println(resp);
        assertNotNull(resp);
    }
}