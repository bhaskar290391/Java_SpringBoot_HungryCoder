package java10;

import java.util.List;

public class VarDemo {
    static void main() {
        var data= List.of("Apple","banana","Cherry");
        for (var fruits:data){
            System.out.println(fruits);
        }
    }}
