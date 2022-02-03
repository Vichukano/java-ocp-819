package ru.vichukano.ocp.oop;

import static ru.vichukano.ocp.oop.BoxingUnboxing.Test.testInts;

public class BoxingUnboxing {


    public static void main(String[] args) {
        Integer val1 = new Integer(5);
        int val2 = 9;
        val1++;
        testInts(val1++, ++val2);
        System.out.println(val1 + " " + val2);
    }

    static class Test {
        public static void testInts(Integer obj, int var) {
            obj = var++;
            obj++;
        }
    }
}
