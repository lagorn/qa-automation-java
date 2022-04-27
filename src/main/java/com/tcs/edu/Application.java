package com.tcs.edu;

import static com.tcs.edu.MessageService.log;
import static com.tcs.edu.decorator.Doubling.DISTINCT;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        //log(MAJOR, DESC, "Hello world!", "Hello Mum!", "Hello Dad!", "Hello Michael!");
        log(MAJOR, ASC, DISTINCT, "Hello world!", "Hello one!", "Hello two!", "Hello three!", "Hello world!", "Hello world!", "Hello world!");
    }
}