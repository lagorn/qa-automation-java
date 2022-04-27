package com.tcs.edu;


import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;

import java.util.*;

import static com.tcs.edu.decorator.Doubling.*;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.SeverityDecorator.addLevelDecorator;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {
    public static int messageCount;

    public static void log(Severity severity, String message, String... messages) {

        if (severity == null) return;

        if (message != null) {
            print(decorate(message + addLevelDecorator(severity)));
        }

        for (String mes : messages) {
            if (mes != null) {
                print(decorate(mes + addLevelDecorator(severity)));
            }
        }
    }

    public static void log(Severity severity, MessageOrder messageOrder, String message, String... messages) {

        if (messageOrder == null) return;

        if (messageOrder == ASC) log(severity, message, messages);

        if (messageOrder == DESC) {
            String[] arrayMessage = new String[messages.length + 1];

            for (int i = 0, j = messages.length - 1; i < arrayMessage.length - 1; i++, j--) {
                arrayMessage[i] = messages[j];
            }
            arrayMessage[arrayMessage.length - 1] = message;

            log(severity, null, arrayMessage);
        }
    }

    public static void log(Severity severity, MessageOrder messageOrder, Doubling doubling, String message, String... messages) {
        if (doubling == null) return;

        if (doubling == DOUBLES) {
            log(severity, messageOrder, message, messages);
        } else if (doubling == DISTINCT) {

            String[] arrayMessage = new String[messages.length + 1];
            arrayMessage[0] = message;

            for (int i = 0, j = 1; i < messages.length; i++, j++) {
                arrayMessage[j] = messages[i];
            }

            HashSet<String> collectionMessage = new LinkedHashSet<>(Arrays.asList(arrayMessage));
            log(severity, messageOrder, null, collectionMessage.toArray(new String[0]));
        }
    }
}