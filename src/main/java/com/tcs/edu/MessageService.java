package com.tcs.edu;


import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;

import java.util.Objects;

import static com.tcs.edu.decorator.SeverityDecorator.addLevelDecorator;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {
    public static int messageCount;

    public static void gluingPrint(Severity severity, String message, String... messages) {

        if ((message != null) && (Objects.nonNull(severity))) {
            print(decorate(message + addLevelDecorator(severity)));

            for (String mes : messages) {
                if (mes != null) {
                    print(decorate(mes + addLevelDecorator(severity)));
                }
            }
        }
    }

    public static void gluingPrint(Severity severity, MessageOrder messageOrder, String message, String... messages) {

        if ((message != null) && (Objects.nonNull(severity)) && (messageOrder != null)) {
            if (messageOrder == MessageOrder.ASR) {
                messageCount = 1;
                print(decorate(message + " " + messageCount++ + addLevelDecorator(severity)));

                for (int i = 0; i < messages.length; i++, messageCount++) {
                    if (messages[i] != null) {
                        print(decorate(messages[i] + " " + messageCount + addLevelDecorator(severity)));
                    }
                }
            } else {
                messageCount = messages.length + 1;
                print(decorate(message + " " + messageCount-- + addLevelDecorator(severity)));

                for (int i = messages.length - 1; i >= 0; i--, messageCount--) {
                    if (messages[i] != null) {
                        print(decorate(messages[i] + " " + messageCount + addLevelDecorator(severity)));
                    }
                }
            }
        }
    }
}