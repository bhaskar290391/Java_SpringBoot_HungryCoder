package com.multithreading.video;

import java.util.concurrent.atomic.AtomicInteger;



class SharedData{

    public AtomicInteger count=new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    public void increment() {
        count.incrementAndGet();
    }
}

public class AtomicIntegerDemo {

    static void main() throws InterruptedException {
        SharedData data=new SharedData();
       Thread t2= new Thread(()-> {

            System.out.println("Thread 1 started");
            for (int i = 0; i < 50000; i++) {
                data.increment();
            }

            System.out.println("Thread 1 is completed ");
        });




   Thread t1= new Thread(()-> {

        System.out.println("Thread 2 started");
        for (int i = 0; i < 50000; i++) {
            data.increment();
        }

        System.out.println("Thread 2 is completed ");
    });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The value of counter is ==>"+data.getCount());
}
}
