package ru.vichukano.ocp.oop;

interface Measurement {
    public static int getBreadth() {
        return 0;
    }

    public static int getHeight() {
        return 0;
    }

    public default int getLength() {
        return 0;
    }
}

/**
 * Интерфейсы не наследуют статические методы.
 */
interface Size extends Measurement {
    public static final int UNIT = 100;

    /**
     * Статический метод имеет одинаковую сигнатуру с дефолтным методом в инитерфейсе родителе.
     * Статический метод не может переопределить дефолтный метод, поэтому этот код не компилируется
     */
    /*public static int getLength() { Не компилируется
        return 10;
    }*/

    /**
     * Так как статические методы в интерфейсах не наследуются(в отличии от классов),
     * статический метод getHeight() в родительском классе не виден и конфликта сигнатур не возникает.
     */
    public default int getHeight() {// Успешно компилируется
        return 1;
    }
}

/**
 * В классах сатические методы наследуются.
 * Переопределить статический метод невозможно, поэтому на одной ветке наследования нельзя иметь
 * статический и нестатический метод с одинаковой сигнатуро.
 */
class A {
    //static void b() {} Не компилируется

    //void a() {} //Не компилирутся

    static void staticMethodInA() {
    }
}

class B extends A {
    static void a() {
    }

    void b() {
    }
}

public class StaticMethodsAndInheritance {
    public static void main(String[] args) {
        B b = new B();
        //B наследует статический метод из А
        b.staticMethodInA();
        B.staticMethodInA();
        A.staticMethodInA();
    }
}
