package java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_To_Stream {
    static void main() {
        //primitive array

        int[] a={1,2,3};
        IntStream intStream=Arrays.stream(a);
        intStream.forEach(System.out::println);

        Integer[] data= {4,5,6};
        Stream<Integer> integerData=Stream.of(data);
        integerData.forEach(System.out::println);

    }}
