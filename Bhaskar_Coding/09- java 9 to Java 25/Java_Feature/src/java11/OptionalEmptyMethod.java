package java11;

import java.util.Optional;

public class OptionalEmptyMethod {
    static void main() {
        Optional<String> bhaskar = Optional.ofNullable("Bhaskar");
        if(bhaskar.isEmpty()){
            System.out.println("data is empty");
        }else {
            System.out.println("data is not empty");
        }
    }
}
