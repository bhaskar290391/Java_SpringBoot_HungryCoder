package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class AsyncMultipleComputation
{
    static void main() {

        CompletableFuture.supplyAsync(()-> 10)
                .thenApply(number -> number *29)
                .thenAccept(number -> System.out.println(number));
    }
}
