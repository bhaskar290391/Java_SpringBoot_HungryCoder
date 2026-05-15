package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ErrorHandlingInCompletablefeature {
    static void main() {
        CompletableFuture.supplyAsync(()->{
            if(true){
                throw new RuntimeException("Checking Runtime exception!!!");
            }
            else {
                return "Succeed !!";
            }
        }).exceptionally( ex-> "Error" + ex.getMessage())
                .thenAccept(System.out::println);
    }
}
