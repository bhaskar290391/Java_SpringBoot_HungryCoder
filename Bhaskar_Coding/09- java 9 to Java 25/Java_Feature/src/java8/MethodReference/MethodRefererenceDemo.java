package java8.MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodRefererenceDemo {
    public static void main() {

        List<Integer> data= Arrays.asList(1,2,3,4,5);
        data.forEach(System.out::println);

        String hello="Hello World";
       Supplier<Integer> length= hello::length;
        System.out.println("Lenghth ==> "+length.get());


        List<String> words = Arrays.asList("apple", "banana", "cherry");
        words.sort(String::compareToIgnoreCase);
        System.out.println(words);
    }
}
