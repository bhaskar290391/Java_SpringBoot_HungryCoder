package java8.core;

import java.util.Optional;

public class OptionalClassDemo {
    public static void main() {
        java.util.Optional<String> data =Optional.of("Bhaskar");
        data.ifPresent(System.out::println);
    }
}
