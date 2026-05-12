package functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class TraditionalVSStreamExample {
    public static void main() {

        List<Integer> data=new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);

        //traditional way
        int sumOfSqaureOfNumber=0;
        for(Integer  pet : data){
            if(pet % 2 ==0){
                int squareOfNumber=pet *pet;
                sumOfSqaureOfNumber +=squareOfNumber;
            }
        }
        System.out.println("The sum using tradition way ==>"+ sumOfSqaureOfNumber);


        int sum = data.stream().filter(number -> number % 2 == 0)
                .mapToInt(number -> number * number)
                .sum();

        System.out.println("The sum using Stream way ==>"+ sum);
    }

}
