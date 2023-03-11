package IOStreams.InputStreamPackage;

import java.io.*;
import java.nio.file.Path;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("SRC", "IOStreams", "RESOURCES", "FileToRead.txt");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path.toFile()));
        StringBuilder value = new StringBuilder();
        int read;
        while ((read = inputStream.read())!=-1){
            value.append((char) read);
        }
        inputStream.close();

        System.out.println(value);
    }
}
