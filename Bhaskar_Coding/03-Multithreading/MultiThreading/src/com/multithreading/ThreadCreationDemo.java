package com.multithreading;

public class ThreadCreationDemo {
   public static  Object Sharedobject= new Object();
    static void main() {

        Runnable runnable1=()->{
            System.out.println("Thread 1 Started !!!");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                System.out.println(Sharedobject.hashCode());
                Thread.sleep(2000);
                System.out.println("Thread 1 Completed !!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2=()->{
            System.out.println("Thread 2 Started !!!");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                System.out.println(Sharedobject.hashCode());
                Thread.sleep(2000);
                System.out.println("Thread 2 Completed !!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(runnable1,"Bhaskar").start();
        new Thread(runnable2,"Kanishk").start();
    }
}
