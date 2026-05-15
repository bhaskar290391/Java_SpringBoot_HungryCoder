package java25;

//Flexible Constructor Bodies (JEP 513)


class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
class  Employee extends  Person{

    //Before java 25
    /*
    public Employee(String name, int age) {
        super(name, age);
        if(age <18 || age >67){
            throw  new RuntimeException("Invalid Age");
        }
    }
    */


    //After java 25
    public Employee(String name, int age) {
        if(age <18 || age >67){
            throw  new RuntimeException("Invalid Age");
        }
        super(name, age);

    }
}
public class ValidationBeforeSuper {
}
