package com.tcs.edu;

import static com.tcs.edu.MessageService.gluingPrint;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        gluingPrint(MAJOR, "Hello world!", "Hello Piter!", "Hello John!");
        gluingPrint(MAJOR, ASR, "Hello world!", "Hello Mum!", "Hello Dad!", "Hello Mum!", "Hello Dad!", "Hello Michael!");
        gluingPrint(MAJOR, DESC, "Hello world!", "Hello Noah!", "Hello Liam!", "Hello Jacob!", "Hello William!");
    }
}