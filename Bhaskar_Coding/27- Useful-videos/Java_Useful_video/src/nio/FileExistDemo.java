package nio;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileExistDemo {
    static void main() {

        try{
            Path tempFile = Files.createTempFile("abc", ".txt");
            System.out.println("File exists ==>" + Files.exists(tempFile));
            System.out.println("File Not exists ==> "+ Files.notExists(tempFile));
            System.out.println("File Is readable ==>"+Files.isReadable(tempFile));
            System.out.println("File is regular ==>"+Files.isRegularFile(tempFile));
            Files.delete(tempFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            Path bhaskar = Files.createTempDirectory("bhaskar");
            System.out.println("Directory exists==>"+ Files.isDirectory(bhaskar));

            Files.delete(bhaskar);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
