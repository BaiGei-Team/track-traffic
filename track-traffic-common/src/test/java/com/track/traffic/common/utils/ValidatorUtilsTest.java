package com.track.traffic.common.utils;

import com.track.traffic.common.exception.BadArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorUtilsTest {

    @Test(expected = BadArgumentException.class)
    public void checkNotNull() {
        ValidatorUtils.checkNotNull(null, "error");
    }
}