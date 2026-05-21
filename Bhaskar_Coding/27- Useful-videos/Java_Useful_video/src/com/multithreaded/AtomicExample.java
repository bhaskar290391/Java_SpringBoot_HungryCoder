package com.multithreaded;

import java.util.concurrent.atomic.AtomicInteger;

class  SharedCounter{
   // private int count=0;
   private AtomicInteger count= new AtomicInteger(0);
    public void setCounter(){
        count.incrementAndGet();
       // count++;
    }

    public int getCount(){
        return count.get();
        //return  count;
    }
}
public class AtomicExample {
    static SharedCounter data=new SharedCounter();
    static void main() throws InterruptedException {

        Thread thread1= new Thread(()-> {
            System.out.println("Thread 1 started");
            for (int i = 0; i <50000 ; i++) {
                data.setCounter();
            }
            System.out.println("Thread 1 completed");
        });

        Thread thread2= new Thread(()-> {
            System.out.println("Thread 2 started");
            for (int i = 0; i <50000 ; i++) {
                data.setCounter();
            }
            System.out.println("Thread 2 completed");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The overall count is ==> "+ data.getCount());
    }
}
