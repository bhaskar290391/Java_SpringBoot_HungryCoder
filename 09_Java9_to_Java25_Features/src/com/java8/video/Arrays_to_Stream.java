package com.java8.video;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_to_Stream {
    static void main() {

        int[] intData={1,2,3,4,5};
        IntStream data=Arrays.stream(intData);
        data.forEach(System.out::println);

        Integer[] integerObject={6,7,8,9};
        Stream<Integer> intergerStream=Stream.of(integerObject);
        intergerStream.forEach(System.out::println);
    }
}
