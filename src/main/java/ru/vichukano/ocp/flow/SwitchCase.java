package ru.vichukano.ocp.flow;

public class SwitchCase {
    public static void main(String[] args) {
        //Инты можно свитчить с char
        int i = 0;
        switch (i) {
            case 'a':
                System.out.println("a");
                break;
            case 'b':
                System.out.println('b');
                break;
            default:
                break;
        }
        //И наоборот, даже с short
        char c = 'c';
        switch (c) {
            case 1:
            case (short)122:
            default:
                break;
        }
    }
}
