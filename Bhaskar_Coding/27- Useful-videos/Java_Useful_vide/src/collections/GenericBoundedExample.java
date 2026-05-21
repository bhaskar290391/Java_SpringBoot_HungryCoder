package collections;

import java.util.Arrays;
import java.util.List;

public class GenericBoundedExample {
    static void main() {

        List<Integer> data= Arrays.asList(2,3,87,78,9);
        List<Double> doubledata=Arrays.asList(89.8,78.0,56.7,0.5,90.5,106.5);

        findMax(data);
        findMax(doubledata);
    }

    private static <T extends  Comparable<T>> void findMax(List<T> data) {

        if(data ==null && data.isEmpty()){
            throw  new RuntimeException("Data is invalid");
        }

        T max=data.get(0);

        for (int i = 1; i < data.size(); i++) {

            T currentElement=data.get(i);

            if(currentElement.compareTo(max) >0 ){
                max= currentElement;
            }
        }
        System.out.println("The max element is "+ max);
    }
}
