package com.java.oops;

abstract class Animals{
    private String name;

    public Animals(String name){
        System.out.println("Abstract class constructor");
    }

    abstract void sleep();

    public void sound(){
        System.out.println("Animal making sound");
    }
}

interface Pet{

    public void play();

    default void defaultMethod(){
        System.out.println("Default Method");
    }

    static void rememberMethod(){
        System.out.println("static Method");
    }
}
class Test extends Animals implements Pet{

    public Test(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("I am play method");
    }

    @Override
    public void defaultMethod() {
        Pet.super.defaultMethod();
        System.out.println("Default method override");
    }

    @Override
    void sleep() {
        System.out.println("I am sleeping method");
    }
}
public class AbstractAndInterface {
    static void main() {
        Test test=new Test("Bhaskar");
        test.defaultMethod();
        test.play();
        test.sound();
        test.sleep();

    }
}
