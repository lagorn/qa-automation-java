package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
    private static String decoratedMessage;
    public static int messageCount = 0;

    public static String decorate(String message){
        decoratedMessage = Instant.now() + message;
        messageCount++;
        return decoratedMessage;
    }
}
