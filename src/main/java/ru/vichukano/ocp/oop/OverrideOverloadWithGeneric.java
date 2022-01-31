package ru.vichukano.ocp.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Переопределение будет работать, только если в сигнатуре будут параметры типа Number.
 * Integer, Double и другие уже перегрузка
 * T extends Number - параметры типа Number = переопределение
 */
class Base {
    public <T extends Number, Z extends Number> Map<T, Z> getMap(T t, Z z) {
        return new HashMap<T, Z>();
    }
}

class Derived extends Base {
    //Перегружает метод, здесь T и Z это параметры другого типа <T, Z> - объявлен свой скоп для этого метода
    //Сигнатура одинаковая, список параметров другой
    public <T, Z> TreeMap<T, Z> getMap(T t, Z z) {
        return new TreeMap<T, Z>();
    }

    //Переопределяет на возвращаемое значение можно не смотреть
    //@Override
    //public  Map<Number, Number> getMap(Number t, Number z) { return new TreeMap<Number, Number>(); }; //2

    //Переопределяет метод
    @Override
    public Map<Integer, Integer> getMap(Number t, Number z) {
        return new HashMap<Integer, Integer>();
    }

    //Перегружает метод
    public Map<Integer, Integer> getMap(Integer t, Integer z) {
        return new HashMap<Integer, Integer>();
    }
}

public class OverrideOverloadWithGeneric {
}
