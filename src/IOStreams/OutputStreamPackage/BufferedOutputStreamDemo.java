package IOStreams.OutputStreamPackage;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "IOStreams", "RESOURCES", "FileToWrite.txt");
        String someText = "Hello Amigos!";
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile()));
        outputStream.write(someText.getBytes());
        outputStream.close();
    }
}
