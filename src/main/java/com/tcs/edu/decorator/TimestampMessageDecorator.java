package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
    public static int messageCount = 0;

    public static String decorate(String message){
        var decoratedMessage = Instant.now() + message;
        messageCount++;
        return decoratedMessage;
    }
}
