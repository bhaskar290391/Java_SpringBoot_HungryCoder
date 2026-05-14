package java8.core;

interface DefaultMethod{
    default void sayHello(){
        System.out.println("I am default method");
    }
}

class  TestDemo implements  DefaultMethod {
    @Override
    public void sayHello() {
        DefaultMethod.super.sayHello();
    }

    public void main() {
        this.sayHello();
    }
}

public class DefaultMethodDemo {
    public static void main() {
        TestDemo d=new TestDemo();
        d.main();
    }
}




