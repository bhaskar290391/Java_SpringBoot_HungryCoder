package java8.functionalInterface;


interface Vehicle {
    public void start();

    default  void honk(){
        System.out.println(" honking sound from default method");
    }
}

class Car implements  Vehicle{

    @Override
    public void start() {
        System.out.println("Car is started");
    }

    @Override
    public void honk() {
        Vehicle.super.honk();
        System.out.println("Honking sound by custom ");
    }
}

public class Data {
    static void main() {
     Car car=new Car();
     car.honk();
     car.start();
    }
}