package com.java8.video;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map_FlatMap_Example {
    static void main() {

        List<String> data=List.of("Hello","World");
        List<String> upperCaseData= data.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseData);

        List<List<Integer>>integerData= Arrays.asList( Arrays.asList(1,2,3), Arrays.asList(4,5,6),Arrays.asList(7,8,9));

        integerData.stream().flatMap(List::stream)
                .map(number -> number *2)
                .forEach(System.out::println);
    }
}
