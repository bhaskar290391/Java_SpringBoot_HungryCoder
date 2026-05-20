package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample_2 {
    static void main() {
        List<Integer> data= Arrays.asList(1,2,3,3,4,5,5,6,7,8,8,9,10);

        System.out.println(data
                .stream()
                .filter(n-> n% 2==0)
                .mapToInt(n-> n * n)
                .sum());

        System.out.println("Count is "+ data.stream().filter(n-> n >5).count());

        System.out.println(data
                .stream().mapToInt(n-> n* n).sum());

    }
}
