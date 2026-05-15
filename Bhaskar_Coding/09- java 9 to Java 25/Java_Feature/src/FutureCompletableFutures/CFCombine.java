package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class CFCombine {
    static void main() {
        CompletableFuture<String> future1= CompletableFuture.supplyAsync(()-> "Task1");
        CompletableFuture<String> future2= CompletableFuture.supplyAsync(()-> "Task2");
        future1.thenCombine(future2,(res1,res2) -> res1+" Bhaskar "+ res2).thenAccept(System.out::println);

    }

}
