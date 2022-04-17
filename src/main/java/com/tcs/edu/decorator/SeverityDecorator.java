package com.tcs.edu.decorator;

public class SeverityDecorator {
    public static String addLevelDecorator(Severity severity){
        String status = null;
        switch (severity) {
            case MINOR:
                status = "()";
                break;
            case REGULAR:
                status = "(!)";
                break;
            case MAJOR:
                status = "(!!!)";
                break;
        }
        return status;
    }
}
