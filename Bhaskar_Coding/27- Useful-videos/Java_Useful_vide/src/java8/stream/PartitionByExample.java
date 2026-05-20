package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByExample {
    static void main() {
        List<Integer> data= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(
        data.stream().collect(Collectors.partitioningBy(n-> n %2 ==0))
                .entrySet().stream().collect(Collectors.toMap
                        (entry -> entry.getKey()?"Even":"odd", Map.Entry::getValue))
        );

        System.out.println(
        data.stream().collect(Collectors.groupingBy(n-> n%2==0? "Even":"Odd")));
    }
}
