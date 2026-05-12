package oops;

class Animal{
    public void eat(){
        System.out.println("oops.Animal is eating");
    }

    public void sleep(){
        System.out.println("oops.Animal is sleeping");
    }
}

class  Dog extends  Animal{
    public void bark(){
        System.out.println("oops.Dog is barking");
    }
}

class  Cat extends  Animal{
    public void meowing(){
        System.out.println("oops.Cat is meowing");
    }
}

public class InheritanceExample {
    public static void main() {
        Dog d=new Dog();
        d.bark();
        d.eat();
        d.sleep();

        Cat c=new Cat();
        c.meowing();
        c.eat();
        c.sleep();
    }
}
