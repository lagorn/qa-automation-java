package com.tcs.edu;

import com.tcs.edu.decorator.OrderedDistinctedMessageService;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        new OrderedDistinctedMessageService(new ConsolePrinter(), new TimestampMessageDecorator()).log(new Message("Hello world!", REGULAR));
    }
}