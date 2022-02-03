package ru.vichukano.ocp.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * super = put - можно положить объекты
 * extends = get - только read-only
 */
public class SuperExtendsExample {

    public static void main(String[] args) {
        //Полиморфизм от Number вверх до Object
        List<? super Number> one = new ArrayList<Number>();
        //Нельзя сделать get без каста
        //Number n = one.get(0);
        List<? super Number> two = new ArrayList<Object>();
        //Не скомпилируется
        //List<? super Number> twoo = new ArrayList<Integer>();
        //Полиморфизм от Nubmer и ниже
        List<? extends Number> three = new ArrayList<Integer>();
        List<? extends Number> four = new ArrayList<Double>();
        //Нельзя положить элемент, но можно взять
        //four.add(Double.valueOf(1.0));
        Number d = four.get(0);
    }

}
