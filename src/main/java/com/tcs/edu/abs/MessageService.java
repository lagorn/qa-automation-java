package com.tcs.edu.abs;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.domain.Message;

public interface MessageService {
    void log(Message message, Message... messages);

    void log(MessageOrder messageOrder, Message message, Message... messages);

    void log(MessageOrder messageOrder, Doubling doubling, Message message, Message... messages);
}
