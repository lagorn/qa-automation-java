package com.tcs.edu.decorator;

import com.tcs.edu.abs.MessageDecorator;
import com.tcs.edu.abs.MessageService;
import com.tcs.edu.abs.Printer;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tcs.edu.decorator.Doubling.DISTINCT;
import static com.tcs.edu.decorator.Doubling.DOUBLES;
import static com.tcs.edu.decorator.MessageOrder.ASC;
import static com.tcs.edu.decorator.MessageOrder.DESC;
import static com.tcs.edu.decorator.SeverityDecorator.addLevelDecorator;

public class OrderedDistinctedMessageService implements MessageService {

    private Printer printer;
    private MessageDecorator messageDecorator;

    public OrderedDistinctedMessageService(Printer printer, MessageDecorator messageDecorator) {
        this.printer = printer;
        this.messageDecorator = messageDecorator;
    }

    public void log(Message message, Message... messages){

        if (message == null) return;

        if ((message.getBody() != null) && (message.getSeverity() != null)) {
            printer.print(messageDecorator.decorate(message.getBody() + addLevelDecorator(message.getSeverity())));
        }

        for (Message mes : messages) {
            if ((mes.getBody() != null) && (mes.getSeverity() != null)) {
                printer.print(messageDecorator.decorate(mes.getBody() + addLevelDecorator(mes.getSeverity())));
            }
        }
    }

    public void log(MessageOrder messageOrder, Message message, Message... messages) {

        if (messageOrder == null) return;

        if (messageOrder == ASC) log(message, messages);

        if (messageOrder == DESC) {
            ArrayList<Message> reverseList = new ArrayList<>(List.of(messages));
            Collections.reverse(reverseList);
            reverseList.add(message);

            log(new Message(null, null), reverseList.toArray(new Message[0]));
        }
    }


    public void log(MessageOrder messageOrder, Doubling doubling, Message message, Message... messages) {
        if (doubling == null) return;

        if (doubling == DOUBLES) {
            log(messageOrder, message, messages);
        } else if (doubling == DISTINCT) {

            ArrayList <Message> reverseList = new ArrayList<>(List.of(messages));
            Collections.reverse(reverseList);
            reverseList.add(message);

            var newArray = reverseList.stream().distinct().toArray(Message[]::new);


            log(messageOrder, new Message(null, null), newArray);
        }
    }
}
