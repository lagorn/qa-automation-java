package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

class Application {
    public static void main(String[] args) {
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
        print(decorate("Hello world!"));
    }
}