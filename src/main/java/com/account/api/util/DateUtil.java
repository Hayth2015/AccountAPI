package com.account.api.util;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;

public class DateUtil {

    public static LocalDateTime getCurrentInstant() {
        Instant instant = Calendar.getInstance().toInstant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}
