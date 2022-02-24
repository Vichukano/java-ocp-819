package ru.vichukano.ocp.oop;

public class InnerOuterClassExample {
    public static String staticText = "Outer class text";
    private static String privateStaticText = "Private static text";
    public String name = "Outer class";
    public String nonStaticText = "Outer class non static text";
    private int num = 0;

    //Создание извне
    public static void main(String[] args) {
        InnerStaticPublic innerStaticPublic = new InnerOuterClassExample.InnerStaticPublic();
        InnerStaticPrivate innerStaticPrivate = new InnerOuterClassExample.InnerStaticPrivate();
        InnerPublic innerPublic = new InnerOuterClassExample().new InnerPublic();
        InnerPrivate innerPrivate = new InnerOuterClassExample().new InnerPrivate();
    }

    //Использование вложенных классов в методах внешнего класса
    //Внутри внешнего класса есть доступ ко всем членам внутреннего (static/nonstatic) класса, в том числе и private
    public void test() {
        InnerStaticPublic innerStaticPublic = new InnerStaticPublic();
        InnerStaticPrivate innerStaticPrivate = new InnerStaticPrivate();
        InnerPublic innerPublic = new InnerPublic();
        InnerPrivate innerPrivate = new InnerPrivate();
        System.out.println(innerPrivate.name);
        System.out.println(innerPublic.num);//Доступ к приватным полям
        System.out.println(innerStaticPublic.num);
    }

    public static class InnerStaticPublic {
        public String name = "Inner static public";
        private int num = 3;

        void test() {
            //Доступ только к статическим членам внешнего класса
            System.out.println(staticText);
            //В том числе и приватным
            System.out.println(privateStaticText);
            //System.out.println(nonStaticText); -- non static нельзя
        }
    }

    private static class InnerStaticPrivate {
        public String name = "Inner static private";
        private int num = 4;

        void test() {
            //Доступ только к статическим членам внешнего класса
            System.out.println(staticText);
            //В том числе и приватным
            System.out.println(privateStaticText);
            //System.out.println(nonStaticText); -- non static нельзя
        }
    }

    public class InnerPublic {
        public String name = "Inner public";
        private int num = 1;

        void test() {
            //Доступ к статическим и нестатическим членам внешнего класса
            System.out.println(staticText);
            //В том числе и к статическим приватным
            System.out.println(privateStaticText);
            //В том числе к нестатическим приватным полям внешнего класса
            System.out.println(InnerOuterClassExample.this.num);
            System.out.println(InnerOuterClassExample.this.name);
            System.out.println(InnerOuterClassExample.this.nonStaticText);
        }
    }

    //Доступен только внутри внешнего класса
    private class InnerPrivate {
        public String name = "Inner private";
        private int num = 2;

        void test() {
            //Доступ к статическим и нестатическим членам внешнего класса
            System.out.println(staticText);
            System.out.println(InnerOuterClassExample.this.name);
            System.out.println(InnerOuterClassExample.this.nonStaticText);
        }
    }
}
