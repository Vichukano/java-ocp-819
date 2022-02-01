package ru.vichukano.ocp.oop;

interface Boiler {
    private static void log(String msg) { //1
        System.out.println(msg);
    }

    public static void shutdown() {
        log("shutting down");
    }

    public void boil();
}

interface Vaporizer extends Boiler {
    public default void vaporize() {
        boil();
        System.out.println("Vaporized!");
    }
}

/**
 * Статический метод ИНТЕРФЕЙСА не может быть вызван по ссылке, только черед дататип интерфейса
 * Справедливо только для ИНТЕРФЕЙСАВ, для объекта класса можно вызвать статический метод по ссылке
 * Это поведение очень полезно для избежания проблем при множественном наследовании.
 * Представьте, что у вас есть класс, реализующий два интерфейса.
 * У каждого из интерфейсов есть статический метод с одинаковым именем и сигнатурой.
 * Какой из них должен быть использован в первую очередь?
 */
class Reactor implements Vaporizer {
    public static void main(String[] args) {
        Vaporizer v = new Reactor();
        v.vaporize();
        //v.shutdown(); вызов по ссылке не компилируется
        Boiler.shutdown(); // Вызов через дататип комплилируется
    }

    public void boil() {
        System.out.println("Boiling...");
    }
}

public class StaticMethodCallInInterface {
}
