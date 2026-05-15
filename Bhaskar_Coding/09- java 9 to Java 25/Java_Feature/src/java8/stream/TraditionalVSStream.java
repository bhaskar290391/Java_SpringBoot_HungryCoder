package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class TraditionalVSStream {
    static void main() {
        List<Integer> data =new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);

        System.out.println("The original Data is ==> "+ data);

        //tradition way : sum of square of even number
        int sum=0;
        for (Integer number :data){
            if (number % 2 ==0){
            int square =number* number;
            sum +=square;

            }
        }
        System.out.println("The traditional way sum is ==>"+ sum);


        //Stream way fo sum of sqaure of even number
        int sumStream=data.stream().filter( number -> number % 2==0).mapToInt(number -> number * number).sum();
        System.out.println("The stream way sum ==> "+sumStream);
    }
}
