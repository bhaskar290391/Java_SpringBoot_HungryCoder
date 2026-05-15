package FutureCompletableFutures;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingByHandle {
    static void main() {
        CompletableFuture<Integer> thowingRunTimeException = CompletableFuture.supplyAsync(() -> {
            if (false) {
                throw new RuntimeException("Thowing run time exception");
            }
            return 10;
        });

        CompletableFuture<Integer> handle = thowingRunTimeException.handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Exception occured !!! " + ex.getMessage());
                return 0;
            }
            return res;
        });

        System.out.println(handle.join());
    }
}
