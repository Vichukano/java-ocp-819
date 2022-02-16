package ru.vichukano.ocp.ionio;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;

public class ConsoleExample {

    public static void main(String[] args) {
        Console console = System.console();
        String line = console.readLine();
        char[] chars = console.readPassword();
        PrintWriter writer = console.writer();
        Reader reader = console.reader();
    }

}
