package oops;

class Employees{
    private String name;
    private int age;

    public Employees(){

    }
    public Employees(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "variableAndDatatypes.Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class EncapsulationDemo {
   public  static void main() {
       Employees e=new Employees("bhaskar",29);
       System.out.println(e);
       e.setName("kanishk");
       System.out.println(e);
    }
}
