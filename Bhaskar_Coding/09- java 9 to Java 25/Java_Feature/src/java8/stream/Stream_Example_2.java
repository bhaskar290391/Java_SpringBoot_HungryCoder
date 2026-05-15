package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream_Example_2 {
    static void main() {
        List<Integer> data = Arrays.asList(1,2,3,3,4,5,6,7,8,8,9,10);

        List<Integer> collect = data.stream().filter(number -> number % 2 == 0).map(n -> n * n).distinct().peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(data.stream().filter(number -> number > 5).count());

        System.out.println(        data.stream().mapToInt(number -> number).sum());


    }
}
