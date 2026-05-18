package com.threading.core;

class MyRunnable implements  Runnable{

    @Override
    public void run() {
        System.out.println("Thread Started ==>" + Thread.currentThread().getName());
    }
}
public class ThreadCreationImplementsRunnable {
    static void main() {
        MyRunnable runnable = new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
