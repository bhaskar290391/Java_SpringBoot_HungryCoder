package java25;
//Primitive Pattern Matching (JEP 507)
public class PrimitiveInpatternMatching {

    //before java 25
    public  static void processValue(Object obj){

        if(obj instanceof  Integer){
            int i=(Integer) obj;
            if(i>0 && i<=127){
                byte b=(byte) i;
                System.out.println("Can Fit into Byte "+b);
            }else{
                System.out.println("Unfit");
            }
        }
    }

    //after java25
    public static void processValue2(Object obj){
        if(obj instanceof Byte b){
            System.out.println("Fit into byte "+b);
        }
    }

    public  static void main(String args[]) {
    Integer data=50;
        byte b=50;
    processValue(data);
    processValue2(b);

    }
}
