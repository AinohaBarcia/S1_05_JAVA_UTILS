package n1exercici5;

import java.io.Serializable;

public class SerializableClass implements Serializable {
    private String name;
    private int edad;

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public SerializableClass(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }
}
