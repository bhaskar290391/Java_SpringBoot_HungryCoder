package com.java.string;

public class ImmutableStringExample {
    static void main() {

        String immutable="Hello";
        //string constant pool

        String str= immutable.concat(" world");
        //heap memory

        String st1= immutable.concat(" world").intern();
        //string constant pool

        String data= new String("Hello world");
        //heap memory

        String data1="Hello world";
        //string constant pool
        System.out.println(data1 == st1);
        System.out.println(data == str);
    }
}
