package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
    public static final int PAGE_SIZE = 2;
    public static int messageCount = 0;

    public static String decorate(String message) {
        final var decoratedMessage = Instant.now() + message;
        if (messageCount % PAGE_SIZE != 0) {
            messageCount++;
            return decoratedMessage;
        } else {
            messageCount++;
            return decoratedMessage + "\n ---";
        }
    }
}
