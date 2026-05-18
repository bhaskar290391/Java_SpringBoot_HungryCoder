package com.multithreading.video;

import java.util.ArrayList;
import java.util.List;

public class VirtualThread {
    static void main() throws InterruptedException {
        int platform_thread=10_000_00;
long start=System.currentTimeMillis();
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                System.out.println("Fetching data from API");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Successfully fetched the dated !!!");
            }
        };

        List<Thread> listThread=new ArrayList<>();
        for (int i = 0; i < platform_thread; i++) {

           // Thread t=new Thread(runnable);
            Thread t=Thread.ofVirtual().unstarted(runnable);
            t.setDaemon(true);
            t.setName("Thread ==> "+i);
            t.start();
            String data= String.format("Thread number is %S",i);
            System.out.println(data);
            listThread.add(t);
        }

        for (Thread thread:listThread){
            thread.join();
            System.out.println(thread.getName()+ " Completed ");

        }

        long end=System.currentTimeMillis();
        System.out.println("Total time in second "+(end-start));
    }




}
