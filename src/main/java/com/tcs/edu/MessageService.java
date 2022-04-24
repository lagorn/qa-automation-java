package com.tcs.edu;


import com.tcs.edu.decorator.Doubling;
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

    public static void gluingPrint(Severity severity, Doubling doubling, MessageOrder messageOrder, String message, String... messages) {
        if (doubling == Doubling.DOUBLES) {
            gluingPrint(severity, messageOrder, message, messages);
        } else {

            String[] arrayMessage = new String[messages.length + 1];

            if ((message != null) && (Objects.nonNull(severity)) && (messageOrder != null)) {
                if (messageOrder == MessageOrder.ASR) {
                    messageCount = 1;
                    print(decorate(message + " " + messageCount++ + addLevelDecorator(severity)));
                    arrayMessage[0] = message;

                    for (int i = 0; i < messages.length; i++, messageCount++) {
                        if (messages[i] != null) {
                            for (int j = 1; j < arrayMessage.length; j++) {
                                if (!duplicateSearch(messages[i], arrayMessage)) {
                                    print(decorate(messages[i] + " " + messageCount + addLevelDecorator(severity)));
                                    arrayMessage[j] = messages[i];
                                }
                            }
                        }
                    }
                } else {
                    messageCount = messages.length + 1;
                    print(decorate(message + " " + messageCount-- + addLevelDecorator(severity)));
                    arrayMessage[0] = message;

                    for (int i = messages.length - 1; i >= 0; i--, messageCount--) {
                        for (int j = 1; j < arrayMessage.length; j++) {
                            if (!duplicateSearch(messages[i], arrayMessage)) {
                                print(decorate(messages[i] + " " + messageCount + addLevelDecorator(severity)));
                                arrayMessage[j] = messages[i];
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean duplicateSearch(String message, String... messages) {
        for (String checkedMessage : messages) {
            if (Objects.equals(message, checkedMessage)) {
                return true;
            }
        }
        return false;
    }
}