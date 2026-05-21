package collections;

import java.util.Arrays;
import java.util.List;

public class WildcardDataEntry {
    static void main() {
        List<Integer> data= Arrays.asList(1,2);
        List<String> hello= Arrays.asList("bhaskar","maddy");

        printList(data);
        printList(hello);

        PrintListWildCard(data);
        PrintListWildCard(hello);

    }

    private static void PrintListWildCard(List<?> hello) {
        for (Object bhaskar : hello){
            System.out.println(bhaskar);
        }
    }

    private static <T> void printList(List<T> data) {
        for (T bhaskar:data){
            System.out.println(bhaskar);
        }
    }
}
