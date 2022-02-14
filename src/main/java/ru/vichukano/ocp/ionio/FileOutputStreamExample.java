package ru.vichukano.ocp.ionio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileOutputStream - если такого файла нет, то автоматом создасте его.
 * Но только, если директория в которой лежит файл существует.
 * FileInputStream - если файла нет, то кинет исключение.
 */
public class FileOutputStreamExample {

    public static void main(String[] args) throws IOException {
        String source = "src/main/resources/file_output_stream_example/test.txt";
        String target = "src/main/resources/file_output_stream_example/copy.txt";
        copy(source, target);
        Files.delete(Path.of(target));//Бросит исключение, если такого файла нет.
    }

    static void copy(String source, String target) throws IOException {
        try (var in = new FileInputStream(source);
             var out = new FileOutputStream(target)) {
            var buff = new byte[1024];
            var bytesRead = 0;
            while ((bytesRead = in.read(buff)) != -1) {
                out.write(buff, 0, bytesRead);
            }
        }
    }
}
