package com.threading.core;

public class InterThreadCommunication {
    public static Object data= new Object();
    public static boolean condition= false;

    static void main() {

        Thread consumer=new Thread(()->{

            synchronized (data){
                while (!condition){
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Consumer resumed !!!");
            }
        });


        Thread producer =new Thread(()->{

            synchronized (data){
                System.out.println("Data produced");
                condition=true;
                data.notifyAll();
            }
        });


        consumer.start();
        producer.start();
    }
}
