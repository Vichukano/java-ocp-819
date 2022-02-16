package ru.vichukano.ocp.ionio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Есть методы для записи и чтения примитивов.
 * При записи, если такого файла нет, то создаст его
 */
public class DataInputOutputStreamExample {

    public static void main(String[] args) throws IOException {
        var path = "src/main/resources/dir2/text.txt";
        try (var out = new DataOutputStream(new FileOutputStream(path));
             var in = new DataInputStream(new FileInputStream(path))) {
            System.out.println("----write to file----");
            out.writeBoolean(true);
            out.writeChar('\n');
            out.writeDouble(20.4);
            out.writeChar('\n');
            out.writeUTF("Hello world");
            System.out.println("----read from file----");
            System.out.println("Boolean: " + in.readBoolean());
            System.out.println("Char: " + in.readChar());
            System.out.println("Double: " + in.readDouble());
            System.out.println("Char: " + in.readChar());
            System.out.println("String: " + in.readUTF());
        }
        Files.delete(Path.of(path));
    }

}
