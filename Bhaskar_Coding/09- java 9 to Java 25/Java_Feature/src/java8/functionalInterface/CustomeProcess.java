package java8.functionalInterface;

public class CustomeProcess{
    public static void main() {
        StringProcessor data =input -> input.toUpperCase();
        String result=data.process("bhaskar");
        System.out.println(result);
    }
}
