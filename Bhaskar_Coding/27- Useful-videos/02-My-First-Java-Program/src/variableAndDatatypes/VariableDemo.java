package variableAndDatatypes;

public class VariableDemo {
   public  static void main() {

        //statically and strongly type language
        //       String name="bhaskar";
        //       name=20;

        //var keyword
        //       var name="bhaskar";
        //       name=20;

        //widening and narrowing
        int number =100;
        double d=number;
       System.out.println(d);

       double den=4.45;
       int data=(int)den;
       System.out.println(data);

       //local variable
       int counter=10;
       System.out.println("The local variable is "+ counter);

       //instance variable
       Employee e1=new Employee();
       e1.name="bhaskar";
       e1.age=20;

       Employee e2=new Employee();
       e2.name="Maddy";
       e2.age=15;

        //static varaible
       System.out.println("Static variable "+ Employee.company);

    }
}
