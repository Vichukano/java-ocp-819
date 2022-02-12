package ru.vichukano.ocp.ionio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Files.move перемещает файл по новому пути. Без указания утрибутов, если файл по перемещаемому пути уже существует,
 * то кинет исключение.
 * С указанием атрибута StandardCopyOption.REPLACE_EXISTING - заменит содержимое файла, если он есть по пути перемещения
 */
public class FilesExample {

    public static void main(String[] args) throws IOException {
        moveExample();
        copyExample();
    }

    /**
     * Переместить файл
     * @throws IOException
     */
    static void moveExample() throws IOException {
        Path source = Path.of("src/main/resources/test.txt");
        Path target = Path.of("src/main/resources/dir1/test2.txt");
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        //Files.move(source, target); - вот так кинет FileAllreadyExistsException, потому что target уже есть в ФС
        //Files.delete(source); - кинет исключение, так как перемещенный файл удаляется
        Files.deleteIfExists(source);// - не кидает исключение
        File fromSource = new File("src/main/resources/test.txt");
        final boolean result = fromSource.delete();// - Не кидает исключение, если файл отсутсвует или нет прав на удаление
        Files.createFile(Path.of("src/main/resources/test.txt"));
    }

    /**
     * Скопировать файл
     * @throws IOException
     */
    static void copyExample() throws IOException {
        Path source = Path.of("src/main/resources/test.txt");
        Path target = Path.of("src/main/resources/dir1/test2.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        //Files.copy(source, target); - вот так кинет FileAllreadyExistsException, потому что target уже есть в ФС
        //Files.delete(source); - кинет исключение, так как перемещенный файл удаляется
        Files.deleteIfExists(source);// - не кидает исключение
        File fromSource = new File("src/main/resources/test.txt");
        final boolean result = fromSource.delete();// - Не кидает исключение, если файл отсутсвует или нет прав на удаление
        Files.createFile(Path.of("src/main/resources/test.txt"));
    }

}
