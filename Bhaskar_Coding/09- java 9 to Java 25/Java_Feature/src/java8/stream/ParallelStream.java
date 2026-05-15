package java8.stream;

import java.util.Arrays;

public class ParallelStream {
    static void main() {
        int[] intArray=new int[100000];
        Arrays.fill(intArray,2);

        long startTime=System.currentTimeMillis();

        long sum = Arrays.stream(intArray).mapToLong(number -> number * number).sum();

        long end= System.currentTimeMillis();

        System.out.println("The todtal time taken for operation :" + (end-startTime));

        long startTimes=System.currentTimeMillis();

        long sums = Arrays.stream(intArray).parallel().mapToLong(number -> number * number).sum();

        long ends= System.currentTimeMillis();

        System.out.println("The total time taken for operation for parelled stream:" + (ends-startTimes));
    }}
