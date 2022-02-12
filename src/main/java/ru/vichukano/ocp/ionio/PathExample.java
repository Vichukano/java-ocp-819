package ru.vichukano.ocp.ionio;

import java.nio.file.Path;

public class PathExample {

    public static void main(String[] args) {
        getName();
    }

    /**
     * При вызове subpath root не считается, так в примере для windows НЕ выведет c:\ - то есть рутт
     * Для Linux проще, тут можно считать по менам директорий
     */
    static void getName() {
        Path windows = Path.of("c:\\programming\\java\\Main.java");
        Path linux = Path.of("/home/programming/java/Main.java");
        System.out.println("Windows root: " + windows.getRoot());
        System.out.println("Windows subpath(0, 1): " + windows.subpath(0, 1));
        System.out.println("Linux root: " + linux.getRoot());
        System.out.println("Linux subpath(0, 1): " + linux.subpath(0, 1));
    }

}
