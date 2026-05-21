package com.multithreaded;

public class ThreadLocalInheritableThreadLocalExample {
    public static void main() {

            ThreadLocal<Long> userIdThreadLocal=new ThreadLocal<>();

            Long userId=1224l;
            Long userId2=4566l;
            Thread t1=new Thread(()->{
                System.out.println("Thread 1 started ");
                userIdThreadLocal.set(userId);
                System.out.println("Thread 1 completed with userId "+ userIdThreadLocal.get());
                userIdThreadLocal.remove();
                System.out.println("Removed ==> "+userIdThreadLocal.get());
            });

        Thread t2=new Thread(()->{
            System.out.println("Thread 2 started ");
            userIdThreadLocal.set(userId2);
            System.out.println("Thread 2 completed with userId "+ userIdThreadLocal.get());
            userIdThreadLocal.remove();
            System.out.println("Removed ==> "+userIdThreadLocal.get());
        });

        t1.start();
        t2.start();

        InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();

        Thread thread3= new Thread(()->{
            inheritableThreadLocal.set("Instagram");
            userIdThreadLocal.set(98088l);
            System.out.println(userIdThreadLocal.get());

            Thread thread4 =new Thread(()->{
                System.out.println("Thread 4 ==> "+ inheritableThreadLocal.get());
                System.out.println("Thread 4 ==> "+ userIdThreadLocal.get());
            });

            thread4.start();
        });

        thread3.start();
    }
}
