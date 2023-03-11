package IOStreams.OutputStreamPackage;

import java.io.*;
import java.nio.file.Path;

public class OStreamDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "IOStreams", "RESOURCES", "FileToWrite.txt");
        String someText = "Hello, I am Java developer!";
        FileOutputStream outputStream = new FileOutputStream(path.toFile());
        outputStream.write(someText.getBytes());
        outputStream.close();
    }
}
