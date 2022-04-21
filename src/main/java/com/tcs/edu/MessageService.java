package com.tcs.edu;


import com.tcs.edu.decorator.Severity;

import java.util.Objects;

import static com.tcs.edu.decorator.SeverityDecorator.addLevelDecorator;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {
    public static void gluingPrint(Severity severity, String message, String... messages) {

        if ((message != null) && (Objects.nonNull(severity))) {
            print(decorate(message + addLevelDecorator(severity)));
        }

        for (String mes : messages) {

            if ((mes != null) && (Objects.nonNull(severity))) {
                print(decorate(mes + addLevelDecorator(severity)));
            }
        }
    }
}