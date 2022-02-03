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
    @Override
    public Map<Integer, Integer> getMap(Number t, Number z) {
        return new HashMap<Integer, Integer>();
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

public class OverrideOverloadWithGeneric {
}
