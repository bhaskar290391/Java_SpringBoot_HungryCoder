package java21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewVirtualThreadDemo {
    static void main() throws ExecutionException, InterruptedException {

        ExecutorService service=  Executors.newVirtualThreadPerTaskExecutor();
        service.submit(()-> System.out.println("Virtual Thread Demo")).get();

       service.shutdown();
    }
}
