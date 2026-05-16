package java23;

//Primitive Types in Pattern Matching (JEP 455)
public class PrimitiveInInstanceOfAndSwitch {
    static void main() {
        Object obj =42;

        if(obj instanceof  int x){
            System.out.println("The value of x ==>"+x);
        }

        switch (obj){
            case int y -> System.out.println("the value of y "+ y);
            default -> System.out.println("No match");
        }
    }}
