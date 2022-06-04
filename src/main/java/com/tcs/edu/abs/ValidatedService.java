package com.tcs.edu.abs;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {

    protected boolean isArgsValid(Message message){
        return ((message.getBody() != null) && (message.getSeverity() != null));
    }
}
