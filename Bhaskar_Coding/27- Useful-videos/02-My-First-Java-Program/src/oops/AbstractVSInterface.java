package oops;

abstract class abstractDemo{

    private String name;

    public abstractDemo(String name) {
        this.name = name;
    }

    abstract  void sounds();

    public void display(){
        System.out.println("I am inside the display method of abstract demo");
    }
}

interface  Pet{

    void displayAbstract();

    default  void displayInterface(){
        System.out.println("Inside the interface default method");
    }

    public static void displayStatic(){
        System.out.println("Static method of interface");
    }
}

class Data extends abstractDemo implements  Pet{


    public Data(String name) {
        super(name);
    }

    @Override
    public void displayAbstract() {
        System.out.println("Override the displayAbstract");
    }


    @Override
    void sounds() {
        System.out.println("Override the sounds");
    }
}
public class AbstractVSInterface {
    public static void main() {
            Data d=new Data("Bhaskar");
            d.displayAbstract();
            d.sounds();
            d.display();
            d.displayInterface();
    }
}
