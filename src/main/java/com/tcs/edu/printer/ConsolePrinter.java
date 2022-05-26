package com.tcs.edu.printer;

import com.tcs.edu.abs.Printer;

/**
 *  Класс com.tcs.edu.printer.ConsolePrinter печатает данные в консоль.
 *  @autor Алтухов Александр
 *
 */
public class ConsolePrinter implements Printer {
    /**
     * Функция вывода сообщения в консоль {@link ConsolePrinter}
     * @param message - сообщение (String)
     */
    public void print(String message) {
        System.out.println(message);
    }
}
