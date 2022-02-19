package ru.vichukano.ocp.ionio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * Files.move перемещает файл по новому пути. Без указания утрибутов, если файл по перемещаемому пути уже существует,
 * то кинет исключение.
 * С указанием атрибута StandardCopyOption.REPLACE_EXISTING - заменит содержимое файла, если он есть по пути перемещения
 * Files.walk, Files.list, Files.find - возвращают Stream<Path>
 */
public class FilesExample {

    public static void main(String[] args) throws IOException {
        moveExample();
        copyExample();
        findExample();
        walkExample();
    }

    /**
     * Переместить файл
     *
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
     *
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

    /**
     * Поиск файлов и директорий в указанную глубину по предикату.
     * Возвращает стрим
     * ТОЛЬКО ОДНА СИГНАТУРА
     *
     * @throws IOException
     */
    static void findExample() throws IOException {
        Path p = Path.of("src/main/resources/files_examples/test1.txt");
        Stream<Path> found = Files.find(p, 5, (path, basicFileAttributes) -> path.toFile().isFile());
        System.out.println("----Files.find----");
        found.forEach(System.out::println);
    }

    /**
     * Пройтись по файлам и каталогам без поиска
     *
     * @throws IOException
     */
    static void walkExample() throws IOException {
        Path p = Path.of("src/main/resources");
        Stream<Path> walk = Files.walk(p, 5, FileVisitOption.FOLLOW_LINKS);
        System.out.println("----Files.walk----");
        walk.forEach(System.out::println);
    }

}
