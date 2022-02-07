package ru.vichukano.ocp.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List.copyOf - новая немодифицируемая коллекция на основе оригенальной. Добавлять, удалять и сортировать нельзя.
 * Если модифицировать оригенальную, то скопированая не затрагивается
 * Не может содержать null, если в копируемой коллекции есть null, то кинет искльчение
 * <p>
 * Arrays.asList - список фиксированого размера. Добавлять и удалять нельзя, но можно сортировать.
 * Если список сделан из массива Arrays.asList([]arr), то изменения в массиве ссылочных типов затрагивают созданный на базе этого
 * массива список
 * <p>
 * Arrays.copyOf - копирование элементов из одного массива в дргой. НЕ глубокая копия, для ссылочных типов данных
 * копируется ссылка. При изменении елемента в оригинальном массиве для ссылочного дататипа изменитя и в копии
 * <p>
 * List.sublist() - проекция на часть оригинального листа. Если оригинальный лист изменился, то меняется и проектция и наоборот
 */
public class ListOfCopyOfArraysAsList {

    public static void main(String[] args) {
        //List.copyOf
        System.out.println("+++++++++++++++++List.copyOf+++++++++++++++++");
        List<String> list = getList();
        System.out.println("Original list: " + list);
        List<String> copy = List.copyOf(list);
        System.out.println("Copy list: " + copy);
        list.add("four");
        System.out.println("Original list after add four: " + list);
        System.out.println("Copy list after add four: " + copy);
        System.out.println("+++++++++++++++++List.subList()+++++++++++++++++");
        List<String> fullList = getList();
        List<String> sublist = fullList.subList(0, 3);
        System.out.println("Original list: " + fullList);
        System.out.println("Sublist " + sublist);
        sublist.add("five");
        System.out.println("Original after modification of sublist: " + fullList);
        //Arrays.asList
        System.out.println("+++++++++++++++++Arrays.asList()+++++++++++++++++");
        List<String> fromArray = Arrays.asList("three", "two", "one");
        fromArray.sort(String::compareTo);
        System.out.println("fromArray after sorting: " + fromArray);
        //Arrays.copyOf()
        System.out.println("+++++++++++++++++Arrays.copyOf+++++++++++++++++");
        Holder[] arr = {new Holder(1), new Holder(2), new Holder(3)};
        Holder[] copyArr = Arrays.copyOf(arr, 3);
        List<Holder> asList = Arrays.asList(arr);
        System.out.println("Original arr: " + Arrays.toString(arr));
        System.out.println("Copy of arr: " + Arrays.toString(arr));
        arr[0].setValue(10);
        System.out.println("Original arr after modification: " + Arrays.toString(arr));
        System.out.println("Copy of arr after modification of original: " + Arrays.toString(copyArr));
        System.out.println("asList of arr after modification of original: " + asList);
    }

    static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        return list;
    }

    static class Holder {
        int value;

        Holder(int value) {
            this.value = value;
        }

        void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
