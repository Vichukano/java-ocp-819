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
        //Варианты, с которыми скомпилируется.
        //Byte condition = 1;
        //var condition = new Integer(1);
        //short condition = (short)1;
        char condition = 'x';
        switch( condition ){
            case 1  : System.out.println("1");   break;
            case 2  : System.out.println("2");   break;
            case 3 : System.out.println("3");  break;
        }
    }
}
