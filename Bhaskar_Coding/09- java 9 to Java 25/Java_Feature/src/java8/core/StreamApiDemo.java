package java8.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main() {
        List<String> data = Arrays.asList("Peter","Paul","Mary");
        List<String> filtereddata = data.stream().filter(name -> name.startsWith("P")).collect(Collectors.toList());
        System.out.println("The filtered data using Stream ==> "+ filtereddata);
    }
}
