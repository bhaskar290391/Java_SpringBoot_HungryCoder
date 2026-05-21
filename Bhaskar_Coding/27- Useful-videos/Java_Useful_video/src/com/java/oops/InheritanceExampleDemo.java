package com.java.oops;
class Animal{
    public void eat(){
        System.out.println("Animal is eating");
    }

    public void sleep(){
        System.out.println("Animal is sleeping");
    }
}

class  Dog extends  Animal{
    public void bark(){
        System.out.println("Dog is barking");
    }
}
class  Cat extends  Animal{

}
public class InheritanceExampleDemo {
    static void main() {
        Dog d=new Dog();
        d.bark();
        d.eat();
        d.sleep();

        Cat c=new Cat();
        c.eat();
        c.sleep();
    }
}
