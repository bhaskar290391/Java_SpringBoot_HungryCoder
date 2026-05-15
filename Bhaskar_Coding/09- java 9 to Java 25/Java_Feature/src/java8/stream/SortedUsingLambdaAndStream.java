package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedUsingLambdaAndStream {
    static void main() {

        List<String> data = Arrays.asList("Charlie", "Alice", "Bob", "Dave");

        List<String> sortedStream=data.stream().sorted((s1,s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        System.out.println(sortedStream);

        data.sort((s1,s2)-> s1.compareTo(s2));
        System.out.println(data);
    }
}
