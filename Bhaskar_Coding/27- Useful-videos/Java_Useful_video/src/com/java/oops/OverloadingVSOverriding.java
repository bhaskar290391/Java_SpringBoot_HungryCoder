package com.java.oops;
class Calculator{
    public int sum(int a,int b){
        int c=a+b;
        System.out.println(c);
        return  c;
    }

    public int sum(int a,int b,int c){
        int d=a+b+c;
        System.out.println(d);
        return  d;
    }

    public double sum(double a,double b){
        double c=a+b;
        System.out.println(c);
        return  c;
    }
}
class  Animal1{
    public  void sound(){
        System.out.println("Animal making sound");
    }
}
class Dog1 extends  Animal1{
    @Override
    public void sound() {
        System.out.println("Dog making sound");
    }

    public void dance(){
        System.out.println("Animal dancing");
    }
}
public class OverloadingVSOverriding {
    static void main() {

        //Overloading
        Calculator c=new Calculator();
        c.sum(1,2);
        c.sum(3,4,5);
        c.sum(3.6,8);


        //Method Overriding
        Animal1 a=new Animal1();
        a.sound();
        Animal1 d=new Dog1();
        d.sound();

    }
}
