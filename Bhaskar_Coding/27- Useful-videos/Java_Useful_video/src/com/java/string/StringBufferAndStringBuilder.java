package com.java.string;

public class StringBufferAndStringBuilder {
    static void main() {
        StringBuffer buffer=new StringBuffer();
        System.out.println(buffer.capacity());
        buffer.append("Buffer");
        System.out.println(buffer.capacity());
        System.out.println(buffer.insert(0," Bhaskar"));
        System.out.println( buffer.toString());
        StringBuilder builder=new StringBuilder();


        StringBuffer data=new StringBuffer();

        Thread t1=new Thread(()-> {
            for (int i = 0; i <1000 ; i++) {
                data.append("A");
            }
        });
        Thread t2=new Thread(()-> {
            for (int i = 0; i <1000 ; i++) {
                data.append("B");
            }
        });

        t1.start();
        t2.start();

        try
        {
        t1.join();
        t2.join();
        }catch(Exception exception){
            System.out.println(exception.toString());
        }

        System.out.println("The total lenghth is ==> "+data.toString().length());
    }
}
