package com.tcs.edu;

import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.messageCount;

class Application {
    public static void main(String[] args) {
        System.out.println(String.format("%d %s", messageCount, decorate(" Hello world!")));
        System.out.println(String.format("%d %s", messageCount, decorate(" Hello world!")));
        System.out.println(String.format("%d %s", messageCount, decorate(" Hello world!")));
        System.out.println(String.format("%d %s", messageCount, decorate(" Hello world!")));
    }
}