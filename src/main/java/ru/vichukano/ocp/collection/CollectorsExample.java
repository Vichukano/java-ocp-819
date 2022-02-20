package ru.vichukano.ocp.collection;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Примеры различных коллекторов.
 * Collectors.joining("-", "+", "*") 1 - делиметр, 2 - префикс(начало всей строки), 3 - суфикс - конец строки
 */
public class CollectorsExample {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 1, 1, 2, 2, 3, 3, 3, 4);
        Map<Integer, List<Integer>> collect1 = nums.stream().collect(Collectors.groupingBy(Function.identity()));
        collect1.forEach((k, v) -> System.out.println("1: key: " + k + " value: " + v));
        Map<Integer, Long> collect2 = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect2.forEach((k, v) -> System.out.println(("2: key: " + k + " value: " + v)));
        String collect3 = nums.stream().map(e -> "" + e).collect(Collectors.joining("-", "+", "*"));
        System.out.println("3: " + collect3);
    }

}
