package ru.vichukano.ocp.oop;

public class InnerOuterClassExample {
    public static String staticText = "Outer class text";
    public String name = "Outer class";
    public String nonStaticText = "Outer class non static text";
    private int num = 0;

    public static void main(String[] args) {
        InnerStaticPublic innerStaticPublic = new InnerOuterClassExample.InnerStaticPublic();
        InnerStaticPrivate innerStaticPrivate = new InnerOuterClassExample.InnerStaticPrivate();
        InnerPublic innerPublic = new InnerOuterClassExample().new InnerPublic();
        InnerPrivate innerPrivate = new InnerOuterClassExample().new InnerPrivate();
    }

    //Использование вложенных классов в методах внешнего класса
    public void test() {
        InnerStaticPublic innerStaticPublic = new InnerStaticPublic();
        InnerStaticPrivate innerStaticPrivate = new InnerStaticPrivate();
        InnerPublic innerPublic = new InnerPublic();
        InnerPrivate innerPrivate = new InnerPrivate();
    }

    public static class InnerStaticPublic {
        public String name = "Inner static public";
        private int num = 3;

        void test() {
            //Доступ только к статическим членам внешнего класса
            System.out.println(staticText);
            //System.out.println(nonStaticText); -- non static нельзя
        }
    }

    private static class InnerStaticPrivate {
        public String name = "Inner static private";
        private int num = 4;
    }

    public class InnerPublic {
        public String name = "Inner public";
        private int num = 1;
    }

    private class InnerPrivate {
        public String name = "Inner private";
        private int num = 2;
    }
}
