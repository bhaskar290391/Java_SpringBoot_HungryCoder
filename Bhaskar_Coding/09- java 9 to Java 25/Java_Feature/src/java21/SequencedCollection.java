package java21;

import java.util.ArrayList;

public class SequencedCollection {
    static void main() {
        //Before java 21
//      var first=arrayList.iterator().next();
//      var last=arrayList.get(arrayList.size-1);

        ArrayList<Integer> data=new ArrayList<>();
        data.add(2023);
        System.out.println(data);

        data.addFirst(2023);
        System.out.println(data);

        data.addLast(2024);
        System.out.println(data);

        System.out.println(data.getFirst());
        System.out.println(data.getLast());
        System.out.println(data.reversed());

        data.removeFirst();
        System.out.println(data);

        data.removeLast();
        System.out.println(data);
    }
}
