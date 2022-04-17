package com.tcs.edu;


import com.tcs.edu.decorator.Severity;

import static com.tcs.edu.decorator.SeverityDecorator.addLevelDecorator;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {
    public static void gluingPrint(Severity severity, String message){
        print(decorate(message, addLevelDecorator(severity)));
    }
}
