package java21;

public class RecordClassinPaternMatching {
    static void main() {

        record Person(String name,int age){};

        Object obj=new Person("Bhaskar",35);

        if(obj instanceof  Person person && person.name.equals("Bhaskar")){
            System.out.println(" Welcome Bhaskar");
        }
    }
}
