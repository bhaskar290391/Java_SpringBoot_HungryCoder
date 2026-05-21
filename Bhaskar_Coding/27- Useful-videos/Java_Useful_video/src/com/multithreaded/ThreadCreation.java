package com.multithreaded;


public class ThreadCreation {

    private static Object data=new Object();
    static void main() {


        Runnable runnable1= ()->{
            System.out.println("Thread 1 started ");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(data.hashCode());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                throw  new RuntimeException("Exception thrown");
            }
        };

        Runnable runnable2= ()->{
            System.out.println("Thread 2 started ");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(data.hashCode());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                throw  new RuntimeException("Exception thrown");
            }
        };

        new Thread(runnable1,"Runnable 1").start();
        new Thread(runnable2,"Runnable 2").start();
        new Thread(()->{

                System.out.println("Thread 3 started ");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState());
                System.out.println(data.hashCode());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exception){
                    throw  new RuntimeException("Exception thrown");
                }

        },"Runnable 3").start();

    }
}
