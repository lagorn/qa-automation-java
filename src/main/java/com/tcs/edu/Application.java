package com.tcs.edu;

import static com.tcs.edu.MessageService.gluingPrint;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        gluingPrint(null, "Hello world!", "Hello Piter!", "Hello John!");
        gluingPrint(MAJOR, null, "Привет милашка", null, "John");
    }
}