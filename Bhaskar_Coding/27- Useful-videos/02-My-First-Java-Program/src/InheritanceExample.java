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
    public void meowing(){
        System.out.println("Cat is meowing");
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
