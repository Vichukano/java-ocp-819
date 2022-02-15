package ru.vichukano.ocp.ionio;

import java.io.*;

/**
 * При десереализации конструктор не вызывается.
 * Если на иерархии наследования есть классы, которые не реализуют Serializable, то вызывается их конструктор,
 * при это там должен присутствовать конструктор без аргуменов иначе исключение.
 */
public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "src/main/resources/alpha.ser";
        var alpha = new Alpha();
        try (var out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(alpha);
        }
        try (var in = new ObjectInputStream(new FileInputStream(path))) {
            System.out.println("-----Start to deserialize-----");
            var a = (Alpha) in.readObject();
            System.out.println(a.age + " " + a.name);
        }
    }

}

class Alpha extends Beta implements Serializable {
    String name = "alpha";
    int age = 100500;

    Alpha() {
        super(10);
        System.out.println("Create new Alpha");
    }
}

class Beta extends Delta {
    String name = "beta";
    int age;

    Beta(int age) {
        System.out.println("Create new Beta");
        this.age = age;
    }

    Beta() {
        System.out.println("Create new Beta");
    }
}

class Delta {
    Delta() {
        System.out.println("Create new Delta");
    }
}
