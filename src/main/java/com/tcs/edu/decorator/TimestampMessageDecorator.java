package com.tcs.edu.decorator;

import java.time.Instant;

import static java.lang.String.format;

public class TimestampMessageDecorator {
    public static final int PAGE_SIZE = 2;
    public static int messageCount;

    public static String decorate(String message, String status) {

        if (++messageCount % PAGE_SIZE == 0) {
            return format("%d %s %s %s %n---", messageCount, Instant.now().toString(), message, status);
        } else {
            return format("%d %s %s %s", messageCount, Instant.now().toString(), message, status);
        }
    }
}