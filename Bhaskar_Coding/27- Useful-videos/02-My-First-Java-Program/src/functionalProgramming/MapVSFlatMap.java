package functionalProgramming;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapVSFlatMap {
    public static void main() {
        List<List<Integer>> data= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
                );

        List<Integer> collect = data.stream().flatMap(List::stream).map(number -> number * 2).collect(Collectors.toList());
        System.out.println("collect ==> "+collect);
    }
}
