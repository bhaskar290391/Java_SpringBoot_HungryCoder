package com.multithreaded;



import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {
    static void main() throws InterruptedException {
        int no_of_thread=100000;
        List<Thread> list=new ArrayList<>();

        Runnable runnable =()->{
            System.out.println("Fetching Data from API");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed fetching from API");
        };

        for (int i = 0; i < no_of_thread; i++) {
            Thread t=Thread.ofVirtual().unstarted(runnable);
            t.setName("Thread : "+i);
            t.start();

            String str=String.format("Thread %s started ",i);
            System.out.println(str);

            list.add(t);
        }

        for (Thread thread:list){
            thread.join();
            System.out.println("Thread Completed "+ thread.getName());
        }
    }
}
