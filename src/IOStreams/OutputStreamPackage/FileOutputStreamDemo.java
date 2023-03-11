package IOStreams.OutputStreamPackage;

import java.io.*;
import java.nio.file.Path;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "IOStreams", "RESOURCES", "FileToWrite.txt");
        String input = "Privet Mir!";
        FileOutputStream stream = new FileOutputStream(path.toFile());
        stream.write(input.getBytes());
        stream.close();
    }
}
