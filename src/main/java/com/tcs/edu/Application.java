package com.tcs.edu;

import static com.tcs.edu.MessageService.gluingPrint;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        gluingPrint(MINOR, "Hello world!");
        gluingPrint(MAJOR, "Hello world!");
        gluingPrint(REGULAR, "Hello world!");
        gluingPrint(MINOR, "Hello world!");
        gluingPrint(MAJOR, "Hello world!");
    }
}