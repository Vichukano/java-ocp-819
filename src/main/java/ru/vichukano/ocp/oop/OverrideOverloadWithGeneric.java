package ru.vichukano.ocp.oop;

import java.util.*;

/**
 * Переопределение будет работать, только если в сигнатуре будут параметры типа Number.
 * Integer, Double и другие уже перегрузка
 * T extends Number - параметры типа Number = переопределение
 */
class Base {
    /**
     * После компиляции это выглядит так Map getMap(Number t, Number z)
     */
    public <T extends Number, Z extends Number> Map<T, Z> getMap(T t, Z z) {
        return new HashMap<T, Z>();
    }
}

class Derived extends Base {
    /**
     * Перегружает метод, здесь T и Z это параметры другого типа так они не T extends Number
     * Сигнатура одинаковая, список параметров другой
     * После компиляции так TreeMap getMap(Object t, Object z) - параметры Object, а не Number
     */
    public <T, Z> TreeMap<T, Z> getMap(T t, Z z) {
        return new TreeMap<T, Z>();
    }

    //Тоже переопределяет метод
    /*@Override
    public <X extends Number, F extends Number> Map<X, F> getMap(X t, F z) {
        return new TreeMap<X, F>();
    }*/


    //Переопределяет, Number ковариантен ? extends Number
    //@Override
    //public  Map<Number, Number> getMap(Number t, Number z) { return new TreeMap<Number, Number>(); }; //2

    /**
     * После компиляции выглядит так Map getMap(Number t, Number z)
     */
    /*@Override
    public Map<Integer, Integer> getMap(Number t, Number z) {
        return new HashMap<Integer, Integer>();
    }*/

    //Разобраться почему это работает, т.к. возвращающий тип не ковариантен
    @Override
    public Map<String, String> getMap(Number t, Number z) {
        return new HashMap<String, String>();
    }

    /**
     * Перегружает метод, из-за параметорв Integer t, Integer z
     * Если бы это были Number, то метод переопределялся
     * Map getMap(Integer t, Integer z) - после компиляции
     */
    public Map<Integer, Integer> getMap(Integer t, Integer z) {
        return new HashMap<Integer, Integer>();
    }
}

/**
 * Пример переопределения методов с конкретной параметризацией.
 * Тип должен быть ковариантным
 */
class Alpha {
    Collection<? extends Number> typeExtends() {
        return new ArrayList<>();
    }

    Collection<? super Number> typeSuper() {
        return new ArrayList<>();
    }

    Collection<Number> concreteType() {
        return new ArrayList<>();
    }
}

class Beta extends Alpha {
    //Переопределяем, так как extends Number = все что Number и ниже на линии наследования
    List<Integer> typeExtends() {
        return null;
    }

    //Переопределяем, так как super Number = все что Number и выше на линии наследования
    List<Object> typeSuper() {
        return null;
    }

    //Здесь может быть только Number, даже Integer указать нельзя super и extends работать не будут, другой тип работать тоже не будет
    List<Number> concreteType() {
        return new ArrayList<>();
    }
}

public class OverrideOverloadWithGeneric {
}
