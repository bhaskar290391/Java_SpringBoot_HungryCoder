package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberSorting {
    static void main() {

        List<Integer> numbers = Arrays.asList(3, 8, 1, 6, 4, 7, 2, 5, 9, 0);
        List<Integer> collect = numbers.stream().filter(number -> number % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(collect);
    }}
