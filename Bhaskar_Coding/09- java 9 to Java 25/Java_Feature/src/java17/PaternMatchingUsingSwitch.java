package java17;

public class PaternMatchingUsingSwitch {
    static void main() {

        Object hello="hello";

        switch (hello){
            case String s-> System.out.println(s.toUpperCase());
            case  int i -> System.out.println(i *2);
            case  null -> System.out.println("null");
            default -> System.out.println("No matched");
        }
    }
}
