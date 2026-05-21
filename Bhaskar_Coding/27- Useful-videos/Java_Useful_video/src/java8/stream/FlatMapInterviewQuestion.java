package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapInterviewQuestion {
    static void main() {
        List<String> data= Arrays.asList("Bhaskar","Mudaliyar");

        List<Character> collect =
                data.stream().flatMap(str -> str.chars().mapToObj(c ->
                        (char) c)).collect(Collectors.toList());

        System.out.println(collect);
    }
}
