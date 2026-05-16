package java13;

public class MultilinetextBlockDemo {
    static void main() {
        String query="select * from employee where name = %s and age> 20";
        String formatedQuery=String.format(query,"bhaskar");
        System.out.println(formatedQuery);
    }
}
