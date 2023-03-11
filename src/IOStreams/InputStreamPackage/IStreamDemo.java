package IOStreams.InputStreamPackage;

import java.io.*;
import java.nio.file.Path;

public class IStreamDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "IOStreams", "RESOURCES", "FileToRead.txt");
        InputStream inputStream = new FileInputStream(path.toFile());
        int read = inputStream.read();
        while (read!=-1){
            System.out.print((char) read);
            read = inputStream.read();
        }
        inputStream.close();
    }
}
