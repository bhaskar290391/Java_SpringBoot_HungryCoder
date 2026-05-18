package com.multithreading.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutors {
    static void main() {
        ExecutorService service= new ThreadPoolExecutor(1,5,0l,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(2));

        for (int i = 1; i <= 5; i++) {
        int taskId=i;
        service.execute(()->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread Pool Executors is executed task "+ taskId+ "By Thread " +Thread.currentThread().getName());
        });
        }
    }
}
