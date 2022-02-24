package ru.vichukano.ocp.arrays;

import java.util.Arrays;

/**
 * Arrays.mismatch - вернет номер первого индекса, где в массивах разные значения
 * Arrays.compare - если префикс одинаковый, то вернет разницу в длинне массивов,
 * если длинна одинаковая, но элементы разные, то вернет -1 или 1.
 * Вернет 0 если, массивы одинаковые
 */
public class ArraysExample {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4, 5, 6};
        int[] c = {3, 10, 12};
        System.out.println("-------Arrays.compare(a, b)-------");
        System.out.println(Arrays.compare(a, b));
        System.out.println("-------Arrays.mismatch(a, b)-------");
        System.out.println(Arrays.mismatch(a, b));
        System.out.println("-------Arrays.compare(a, c)-------");
        System.out.println(Arrays.compare(a, c));
        System.out.println("-------Arrays.mismatch(a, c)-------");
        System.out.println(Arrays.mismatch(c, a));
    }

}
