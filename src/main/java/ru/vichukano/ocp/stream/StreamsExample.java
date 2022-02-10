package ru.vichukano.ocp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        double avg1 = stream.mapToInt(x -> x).average().getAsDouble();
        double avg2 = stream.mapToDouble(x -> x).average().getAsDouble();
        double avg3 = stream.mapToLong(x -> x).average().getAsDouble();
        double avg4 = stream.collect(Collectors.averagingDouble(x -> x));
        double avg5 = stream.collect(Collectors.averagingInt(x -> x));
        double avg6 = stream.collect(Collectors.averagingLong(x -> x));
    }

}
