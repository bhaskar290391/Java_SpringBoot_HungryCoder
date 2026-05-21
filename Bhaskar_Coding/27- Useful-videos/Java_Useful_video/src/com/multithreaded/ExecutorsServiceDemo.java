package com.multithreaded;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsServiceDemo {
    static void main() {

        ExecutorService service= Executors.newSingleThreadExecutor();
        for (int i = 1; i <6 ; i++) {
            int taskId=i;
            service.submit(()->{
                System.out.println("Task "+ taskId +" is executed by thread "+Thread.currentThread().getName());
            });
        }
        service.shutdown();


        ExecutorService fixedThread= Executors.newFixedThreadPool(3);
        for (int i = 1; i <6 ; i++) {
            int taskId=i;
            fixedThread.submit(()->{
                System.out.println(" Fixed Thread Pool : Task "+ taskId +" is executed by thread "+Thread.currentThread().getName());
            });
        }
        fixedThread.shutdown();


        ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        for (int i = 1; i <6 ; i++) {
            int taskId=i;
            cachedThreadPool.submit(()->{
                System.out.println(" Cached Thread Pool : Task "+ taskId +" is executed by thread "+Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();

        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(2);
        for (int i = 1; i <6 ; i++) {
            int taskId=i;
            scheduledExecutorService.schedule(()->{
                System.out.println(" Scheduled Thread Pool : Task "+ taskId +" is executed by thread "+Thread.currentThread().getName());
            },3, TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();
    }
}
