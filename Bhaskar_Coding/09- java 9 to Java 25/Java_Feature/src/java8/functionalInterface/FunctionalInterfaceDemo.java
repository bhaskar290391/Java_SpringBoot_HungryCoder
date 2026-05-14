package java8.functionalInterface;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
    public void execute();

    default void sayHello(){
        System.out.println("I am default method");
    }

    public static void hello(){
        System.out.println("I am static method of functional interface");
    }
}
