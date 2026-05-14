package java8.core;

@FunctionalInterface
interface interf{
    void execute();
}

public class FunctionInterfaceDemo {
    public  static void main() {
        interf f=()-> System.out.println("I am using function interface  which is invoked by lambda expresssion");
        f.execute();
    }}
