package com.multithreading.video;

import java.util.Locale;

public class ThreadLocalExample {
    static void main() {

        ThreadLocal<Long> userThreadLocal=new ThreadLocal<>();

        long userId1=12345;
        long userId2=67895;

        Thread thread1=new Thread(()->{

            System.out.println("Thread 1 Started");
            userThreadLocal.set(userId1);
            System.out.println("user id Updated in the Thread local");
            System.out.println("fetching Thread 1 Thread local "+userThreadLocal.get());
            userThreadLocal.remove();
            System.out.println("Removed !!! "+ userThreadLocal.get());
        });



        Thread thread2=new Thread(()->{

            System.out.println("Thread 2 Started");
            userThreadLocal.set(userId2);
            System.out.println("user id Updated in the Thread local");
            System.out.println("fetching Thread 2 Thread local "+userThreadLocal.get());
            userThreadLocal.remove();
            System.out.println("Removed !!! "+ userThreadLocal.get());
        });

        thread1.start();
        thread2.start();



        //Inheritable Thread local ;

        InheritableThreadLocal<String>  inheritableThreadLocal=new InheritableThreadLocal<>();

        Thread thread3 =new Thread(()->{

            inheritableThreadLocal.set("Instagram");
            userThreadLocal.set(12345678l);
            System.out.println("Thread local for parents" + userThreadLocal.get());
            Thread thread4 =new Thread(()->{
                System.out.println("Inheritable thread local "+inheritableThreadLocal.get());
                System.out.println("Parent Thread local "+ userThreadLocal.get());



            });

            thread4.start();
        });

        thread3.start();
    }
}
