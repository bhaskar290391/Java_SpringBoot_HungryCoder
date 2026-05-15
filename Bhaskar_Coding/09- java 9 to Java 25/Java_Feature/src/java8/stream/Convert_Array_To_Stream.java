package java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Convert_Array_To_Stream {
    static void main() {

        //Primitive arry to stream
        int[] data ={1,2,3,4,5};
        IntStream intStream = Arrays.stream(data);
        intStream.forEach(System.out::println);

        //Object to stream
        Integer[]  integers={6,7,8};
        Stream.of(integers).forEach(System.out::println);
    }
}
