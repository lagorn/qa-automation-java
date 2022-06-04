package com.tcs.edu.decorator;

import com.tcs.edu.abs.MessageDecorator;

import java.time.Instant;

import static java.lang.String.format;

public class TimestampMessageDecorator implements MessageDecorator {
    public static final int PAGE_SIZE = 2;
    public static int messageCount;

    @Override
    public String decorate(String message) {

        if (++messageCount % PAGE_SIZE == 0) {
            return format("%d %s %s %n---", messageCount, Instant.now().toString(), message);
        } else {
            return format("%d %s %s", messageCount, Instant.now().toString(), message);
        }
    }
}