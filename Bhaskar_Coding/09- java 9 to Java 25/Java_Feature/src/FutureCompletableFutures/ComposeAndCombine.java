package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ComposeAndCombine {
    static void main() {
        System.out.println(CompletableFuture.supplyAsync(()->10)
                .thenCompose(result-> CompletableFuture.supplyAsync(()->result * 20)).join());

        CompletableFuture<String> future1= CompletableFuture.supplyAsync(()-> "Task1");
        CompletableFuture<String> future2= CompletableFuture.supplyAsync(()-> "Task2");
        future1.thenCombine(future2,(res1,res2) -> res1+" Bhaskar "+ res2).thenAccept(System.out::println);
    }
}
