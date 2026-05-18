package com.threading.core;

public class DaemonThreadExample {
    static void main() throws InterruptedException {
        Thread deamonThread =new Thread(()->{
            System.out.println("true");
            while(true){
                System.out.println("Started the Demon thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        deamonThread.setDaemon(true);
        deamonThread.start();

        Thread.sleep(100000);
    }
}
