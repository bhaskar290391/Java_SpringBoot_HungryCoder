package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map_Vs_FlatMap {
    static void main() {
        List<String> stringData= Arrays.asList("hello","Bhaskar");
        System.out.println( stringData.stream().map(user-> user.toUpperCase()).collect(Collectors.toList()));



        List<List<Integer>> data= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        data.stream().flatMap(List::stream).mapToInt(n-> n* n).forEach(System.out::println);
    }
}
