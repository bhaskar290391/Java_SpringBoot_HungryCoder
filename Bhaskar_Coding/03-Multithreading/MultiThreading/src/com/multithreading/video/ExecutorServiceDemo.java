package com.multithreading.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main() {

        ExecutorService singleThreadExecutors= Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            final int taskId=i;
            singleThreadExecutors.submit(()-> System.out.println("Single Thread task "+taskId +" " +
                    "is executed by thread "+Thread.currentThread().getName() ));
        }
        singleThreadExecutors.shutdown();


        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId=i;
            fixedThreadPool.submit(()-> System.out.println("Fixed Thread task "+taskId +" " +
                    "is executed by thread "+Thread.currentThread().getName() ));
        }
        fixedThreadPool.shutdown();


        ExecutorService newCachedThreaPool= Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            final int taskId=i;
            newCachedThreaPool.submit(()-> System.out.println("Cached Thread task "+taskId +" " +
                    "is executed by thread "+Thread.currentThread().getName() ));
        }
        newCachedThreaPool.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            final int taskId=i;
            scheduledExecutorService.schedule(()-> System.out.println("scheduledExecutorService Thread task "+taskId +" " +
                    "is executed by thread "+Thread.currentThread().getName() ),3, TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();

    }
}
