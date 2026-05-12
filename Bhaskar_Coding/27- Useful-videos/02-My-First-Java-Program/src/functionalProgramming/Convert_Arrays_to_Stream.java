package functionalProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Convert_Arrays_to_Stream {
    public static void main() {

        //primitive array
        int[] data= {1,2,3,4,5};
        IntStream intStream = Arrays.stream(data);
        intStream.forEach(System.out:: println);

        System.out.println();
        //NonPrimitive type
        Integer[] integers ={7,8,9};
        Stream data2=Stream.of(integers);
        data2.forEach(System.out::println);
    }
}
