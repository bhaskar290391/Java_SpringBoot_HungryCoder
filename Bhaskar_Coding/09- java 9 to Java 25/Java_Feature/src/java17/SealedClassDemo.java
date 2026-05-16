package java17;
sealed  class Shape permits Circle,Rectangle,Triangle{}

final  class Circle extends  Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
final  class Rectangle extends  Shape{
    private double length;
private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }
}
final  class Triangle extends  Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
public class SealedClassDemo {
    static void main() {
        Shape circles =new Circle(5);
        switch (circles){
            case Circle circle-> System.out.println(Math.PI * circle.getRadius()* circle.getRadius());
            case  Rectangle rectangle-> System.out.println(rectangle.getLength() *rectangle.getBreadth());
            case  Triangle triangele-> System.out.println(0.5 * triangele.getBase()* triangele.getHeight() );
            default -> throw new IllegalStateException("Unexpected value: " + circles);
        };
    }
}
