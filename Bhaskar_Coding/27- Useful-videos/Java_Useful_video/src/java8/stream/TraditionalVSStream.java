package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraditionalVSStream {
    static void main() {


        List<Integer> data=Arrays.asList(1,2,3,4,5);
        System.out.println(data);

        //Traditional way for sum of square of even number
       int sumOfSquare=0;
        for (Integer number:data){
            if(number % 2 ==0){
                sumOfSquare+= number * number;
            }
        }
        System.out.println("The sum of square of even number by traditional "+ sumOfSquare);

        int sum = data.stream().filter(number -> number % 2 == 0)
                .mapToInt(number -> number * number).sum();

        System.out.println("Sum of square by Stream "+ sum);

    }
}
