package java25;
//Flexible Constructor Bodies (JEP 513)
class Persons{


}
class  Employees extends  Persons{
    private String name;
    //Before java 25
    /*
    public Employee(String name) {
        super();
       this.name=name;
    }
    */


    //After java 25
    public Employees(String name) {
        this.name=name;
        super();

    }
}
public class FieldInitializationBeforeSuperThis {
    static void main() {

    }
}
