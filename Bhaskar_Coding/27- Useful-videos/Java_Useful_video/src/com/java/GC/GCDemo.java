package com.java.GC;

public class GCDemo {
    static void main() throws InterruptedException {
        for (int i = 0; i <100000 ; i++) {
            Object data=new Object();
        }

        System.gc();

        Thread.sleep(5000);

        byte[] data=new byte[150*1024*1024];

        for (int i = 0; i <5000 ; i++) {
            Object data1=new Object();
        }

        System.gc();


        //java -XX:+PrintGCDetails -Xmx256m -cp ..\..\.. com.java.GC.GCDemo > gclog.txt

    }
}
