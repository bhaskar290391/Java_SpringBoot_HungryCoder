package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class AllOfMethodOFCompletablefeature {
    static void main() {

        CompletableFuture<Integer> future1= CompletableFuture.supplyAsync(()-> 10);
        CompletableFuture<Integer> future2= CompletableFuture.supplyAsync(()-> 20);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2);

        voidCompletableFuture.thenRun(()-> {
            System.out.println("Data is success");
        });

    }
}
