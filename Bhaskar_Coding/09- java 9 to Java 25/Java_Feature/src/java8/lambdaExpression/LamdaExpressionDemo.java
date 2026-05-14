package java8.lambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Maths{
    int operate(int a, int b);
}

public class LamdaExpressionDemo {
    public static void main() {

        //Using already existing Function interface
        Runnable runnable =()-> System.out.println("I am calling the thread method");
        new Thread(runnable).start();


       //Using collection
        List<String> data = Arrays.asList("one","two","Three");
        data.forEach(item -> System.out.println(item));
        
        //Using Stream
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().map(item -> item * item).collect(Collectors.toList());
        System.out.println(collect);

        //custom Function interface
        Maths addition=(a,b)-> a+b;
        Maths multiplication=(a,b)-> a*b;

        System.out.println(addition.operate(10,5));
        System.out.println(multiplication.operate(10,5));
    }
}
