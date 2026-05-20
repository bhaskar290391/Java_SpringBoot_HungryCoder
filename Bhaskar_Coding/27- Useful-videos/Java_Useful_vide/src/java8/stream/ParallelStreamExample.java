package java8.stream;

import java.util.Arrays;

public class ParallelStreamExample {
    static void main() {
        int num[]=new int[100000];
        Arrays.fill(num,29);

        long startTime=System.currentTimeMillis();
        int sum= Arrays.stream(num).sum();
        System.out.println("The sum ==> "+ sum);
        long endTime=System.currentTimeMillis();
        System.out.println("The time for sum "+ (endTime-startTime));

        long startTimeParraled=System.currentTimeMillis();
        int sumparallel= Arrays.stream(num).parallel().sum();
        System.out.println("The sumparallel ==> "+ sumparallel);
        long endTimeParallel=System.currentTimeMillis();
        System.out.println("The time for sum "+ (endTimeParallel-startTimeParraled));
    }
}
