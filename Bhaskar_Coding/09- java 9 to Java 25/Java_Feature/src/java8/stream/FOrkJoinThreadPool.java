package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class FOrkJoinThreadPool {
    public static void main() throws ExecutionException, InterruptedException {

        List<Integer> numbers = Arrays.asList(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10
        );

        numbers.parallelStream().peek(number -> System.out.println(Thread.currentThread().getName() +" processing the number "+ number))
                .forEach(number ->{});

        System.out.println("Custome Forkjoin pool");
        ForkJoinPool customThreadPool = new ForkJoinPool(4);

        customThreadPool.submit(()->
                numbers.parallelStream().peek(number -> System.out.println(Thread.currentThread().getName() +" processing the number "+ number))
                        .forEach(number ->{})
        ).get();

        customThreadPool.shutdown();
    }
}
