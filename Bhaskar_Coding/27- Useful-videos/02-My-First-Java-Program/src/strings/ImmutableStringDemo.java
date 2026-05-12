package strings;

public class ImmutableStringDemo {
    public static void main() {

        String s1="Hello";
        //string pool

        String s2= s1.concat(" World");
        //heap memory
        String s3= s1.concat(" World").intern();
        //string pool
        String s4="Hello World";
        //string pool
        String s5=new String("Hello World");
        //heap memory
        System.out.println(s3 == s4);
        System.out.println(s2 == s5);
    }
}
