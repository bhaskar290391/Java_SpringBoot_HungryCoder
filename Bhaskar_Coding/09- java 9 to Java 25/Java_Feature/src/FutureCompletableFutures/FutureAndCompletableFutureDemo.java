package FutureCompletableFutures;

import java.util.concurrent.*;

public class FutureAndCompletableFutureDemo {
    static void main() throws ExecutionException, InterruptedException {

        ExecutorService service= Executors.newSingleThreadExecutor();

        Future<Integer> submit = service.submit(() -> {
            Thread.sleep(1000);
            return 10;
        });
       Integer data= submit.get();
        System.out.println(data);


        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        integerCompletableFuture.thenAccept(datas -> System.out.println(datas));
    }
}
