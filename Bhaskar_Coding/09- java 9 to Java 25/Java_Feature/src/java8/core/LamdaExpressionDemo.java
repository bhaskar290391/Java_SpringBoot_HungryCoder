package java8.core;

import java.util.Arrays;
import java.util.List;

public class LamdaExpressionDemo {
    public static void main() {
        List<String> data =Arrays.asList("Peter","paul","Mary");
        data.forEach(datas -> System.out.println("The data is using lambda expression==>"+ datas));
    }
}
