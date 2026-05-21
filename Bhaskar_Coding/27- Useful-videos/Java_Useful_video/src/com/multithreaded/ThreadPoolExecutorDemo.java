package com.multithreaded;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    static void main() {
        ExecutorService service= new ThreadPoolExecutor(1,5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(2));

        for (int i = 0; i <6; i++) {
            int taskId=i;
            service.execute(()-> {
                System.out.println("Thread Pool executors with task Id "+ taskId +" is executed by Thread "+Thread.currentThread().getName());
            });
        }

        service.shutdown();
    }
}
