package FutureCompletableFutures;

import java.util.concurrent.*;

public class FutureAndCompletableFutureDemo2 {
    static void main() throws ExecutionException, InterruptedException {

        ExecutorService service= Executors.newSingleThreadExecutor();

        Future<String> submit = service.submit(() -> {
            Thread.sleep(1000);
            return "Hello future";
        });
        String data= submit.get();
        System.out.println(data);


        CompletableFuture<Void> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "Hello Completable Future";
        }).thenAccept(System.out::println);
    }
}
