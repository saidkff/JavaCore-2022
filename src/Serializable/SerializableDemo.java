package Serializable;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class SerializableDemo{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("src", "Serializable", "FileToSave.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
        User zhavokhir = new User("Zhavokhir");
        outputStream.writeObject(zhavokhir);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()));
        User user = (User) inputStream.readObject();
        System.out.println(user);
    }
}
