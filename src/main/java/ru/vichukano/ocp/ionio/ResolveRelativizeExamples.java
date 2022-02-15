package ru.vichukano.ocp.ionio;

import java.nio.file.Path;

/**
 * resolve - склеить два пути. Первый путь может быть абсолютным и относительным.
 * Если второй путь абсолютный, то вернет его. Если относительный, то склеит
 * <p>
 * relativize - как добраться из одной директории в другую
 * Оба пути должны быть или абсолютными, или относительными, иначе IllegalArgumentException
 * <p>
 * resolveSibling- заменить крайний элемент из пути на other. Если other абсолютный путь или у source нет пути высшего уровня,
 * то вернет other
 */
public class ResolveRelativizeExamples {

    public static void main(String[] args) {
        System.out.println("---------resolve---------");
        Path current = Path.of("C:\\dir1\\dir2\\..\\dir3");
        Path given = Path.of("dir4\\dir5");
        Path abs = Path.of("D:\\dir6");
        System.out.println("absolute + relative:\t" + current.resolve(given));
        System.out.println("absolute + absolute returns param as is:\t" + current.resolve(abs));
        System.out.println("---------relativize---------");
        Path iAmHere = Path.of("/home/dir1/dir2");
        Path wantToGetThere = Path.of("/dir3/dir4");
        System.out.println("Path from iAmHere to wantToGetThere:\t" + iAmHere.relativize(wantToGetThere));
        System.out.println("---------resolveSibling---------");
        Path p = Path.of("/home/dir1/dir2/.vimrc");
        Path resolveSibling = p.resolveSibling("test");
        System.out.println("resolveSibling:\t" + resolveSibling);
    }

}
