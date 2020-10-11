package com.track.traffic.domain;

import com.track.traffic.common.errcode.ErrorCode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RpcResultTest {

    @org.junit.Test
    public void success() {
        RpcResult<Boolean> resp = RpcResult.success(true);
        assertTrue(resp.getSuccess());
    }

    @org.junit.Test
    public void fail() {
        assertFalse(RpcResult.fail(ErrorCode.SYSTEM_ERROR, "error").getSuccess());
    }
}