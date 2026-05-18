package com.threading.core;

class MyThread extends  Thread{
    @Override
    public void run() {
        System.out.println("Thread Started "+ Thread.currentThread().getName());
    }
}
public class ThreadCreationExtendingThread {
    static void main() {
        MyThread thread= new MyThread();
        thread.start();
    }
}
