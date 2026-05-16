package java10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListInCollection {
    static void main() {
        List<String> data=Arrays.asList("Bhakar","Mudaliyar");
       List<String> unChangedData= Collections.unmodifiableList(data);
       unChangedData.add("Maddy");    
    }
}
