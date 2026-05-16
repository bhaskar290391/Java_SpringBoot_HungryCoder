package java16;

record Product(int id,String name ,double price){}
public class RecordDemo {
    public static void main() {
        Product data=new Product(1,"Laptop",129.99);
        System.out.println(data);
        System.out.println(data.price());

    }
}
