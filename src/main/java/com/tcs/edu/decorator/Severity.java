package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

public enum Severity {
    /**
     * Функция вывода сообщения в консоль {@link ConsolePrinter}
     *@param MINOR - сообщение ()
     *@param REGULAR - сообщение (!)
     *@param MAJOR - сообщение (!!!)
     */

    MINOR, REGULAR, MAJOR
}
