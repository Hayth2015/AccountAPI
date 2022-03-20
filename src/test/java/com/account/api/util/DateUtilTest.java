package com.account.api.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateUtilTest {

    @Test
    void testGetCurrentInstant() {
        LocalDateTime localDateTime = DateUtil.getCurrentInstant();
        assertNotNull(localDateTime);
    }
}