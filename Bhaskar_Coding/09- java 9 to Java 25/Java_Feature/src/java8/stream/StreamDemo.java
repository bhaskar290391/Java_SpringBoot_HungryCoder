package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    static void main() {
        //Traditional way
        List<String> names= Arrays.asList("Alice","BOB","Charlie","Dave");
        List<String> longName= new ArrayList<>();

        for (String name: names){
            if(name.length()> 3){
                longName.add(name);
            }
        }
        System.out.println("The collection of data is ==>"+ longName);

        //Stream way
        List<String> collect = names.stream().filter(name -> name.length() > 3).collect(Collectors.toList());
        System.out.println(collect);
    }
}
