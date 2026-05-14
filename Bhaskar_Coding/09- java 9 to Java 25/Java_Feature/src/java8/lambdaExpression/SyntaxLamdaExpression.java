package java8.lambdaExpression;

import java.util.function.IntBinaryOperator;

public class SyntaxLamdaExpression {
    public static void main() {

        //no paranthesis
        Runnable helloWorld = () -> System.out.println("Hello World ");

        //single parameter
        //x-> x *x;

        //multiple parameters
        //(x,y)-> x+y;

        //parameter with declared types
        //(int x,int y)-> x+y;

        //multiple line statement
        /*

        IntBinaryOperator intBinaryOperator = (int x, int y) -> {
            int sum = x + y;
            return sum;

        };*/
    }
}
