package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;

public class Message {
    private String body;
    private Severity severity;

    public Message(String body, Severity severity) {
        this.body = body;
        this.severity = severity;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", severity=" + severity +
                '}';
    }
}