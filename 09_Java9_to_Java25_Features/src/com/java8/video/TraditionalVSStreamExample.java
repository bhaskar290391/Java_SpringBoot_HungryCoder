package com.java8.video;

import java.util.List;

public class TraditionalVSStreamExample {

    //Find the sum of square of even number
    static void main() {

        List<Integer> data=List.of(48,15,45,12,06,78,17,69);

        //Traditional way
        int sum=0;
        for(Integer number:data){
            if(number %2 ==0){
                sum +=(number * number);
            }
        }
        System.out.println("Sum  by traditional way " + sum);
        //Stream way
        int sumByStream =data.stream().filter(n-> n%2 ==0).mapToInt(n -> n*n).sum();
        System.out.println("Sum  by traditional way " + sumByStream);

    }
}
