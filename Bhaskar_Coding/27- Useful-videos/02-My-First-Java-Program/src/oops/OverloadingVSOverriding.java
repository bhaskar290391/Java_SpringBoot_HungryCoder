package oops;

class Calculator{

    public int sum (int a,int b){
        int c=a+b;
        System.out.println(c);
        return  c;
    }

    public int sum (int a,int b,int c){
        int d=a+b+c;
        System.out.println(d);
        return  d;
    }

    public double sum (double a,double b){
        double c=a+b;
        System.out.println(c);
        return  c;
    }
}

class Animals{
    public void sounds(){
        System.out.println("Animal are making sounds");
    }
}

class Dogs extends  Animals{
    @Override
    public void sounds() {
        System.out.println("Dog is making sound");
    }
}

public class OverloadingVSOverriding {
    public static void main() {
            Calculator c=new Calculator();
            c.sum(5,5);
            c.sum(10.2,10.3);
            c.sum(2,5,10);

            Animals a=new Animals();
            a.sounds();

            Animals b=new Dogs();
            b.sounds();
    }
}
