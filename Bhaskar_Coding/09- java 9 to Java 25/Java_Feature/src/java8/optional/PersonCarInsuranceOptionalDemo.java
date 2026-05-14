package java8.optional;

import java.util.Optional;

class Insurance{
    private String name;

    public Insurance(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Car{
   private Insurance insurance;

    public Car(Insurance insurance){
    this.insurance=insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}

class Person{
    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

public class PersonCarInsuranceOptionalDemo {
    public static void main() {

       Insurance insurance =new Insurance("HDFC");

        Car car=new Car(insurance);
        Person person=new Person(car);

        //WITHOUT OPTIONAL

        if(person != null){
            Car carObject=person.getCar();
            if(carObject !=null){
                Insurance data= carObject.getInsurance();

                if(data !=null){
                    System.out.println(data.getName());
                }
            }
        }

        //With optional
        Optional<String> datas = Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown").describeConstable();

    }
}
