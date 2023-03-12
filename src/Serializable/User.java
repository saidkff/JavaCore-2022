package Serializable;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    private int id = 9;
    private transient String name; // Значаение name не будет сохранятся в файл при сериализации

    public User(String name) {
        this.name = name;
        id++;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                " id='" + id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
