package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    static void main() {
        List<List<Integer>> data= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> collect = data.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
