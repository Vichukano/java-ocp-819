package ru.vichukano.ocp.oop;


interface House {
    public default void lockTheGates() {
        System.out.println("Locking House");
    }
}

interface Office {
    public void lockTheGates();
}

/**
 * Класс переопределяет дефолтный метод интерфейса House, при этом реализуя Office
 * Если из House удалить реализацию lockTheGates, то не компилируется, т.к. абстрактный метод из Office
 * будет не реализован
 */
class HomeOffice implements House, Office {
    public void lockTheGates() {
        System.out.println("Locking HomeOffice");
    }
}

public class OverrideDefaultInterfaceMethod {
    public static void main(String[] args) {
        Office off = new HomeOffice();  //Успешная компиляция
        off.lockTheGates(); //Locking HomeOffice
    }
}
