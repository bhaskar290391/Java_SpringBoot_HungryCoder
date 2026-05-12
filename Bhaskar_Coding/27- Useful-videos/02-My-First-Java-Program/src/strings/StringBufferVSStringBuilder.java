package strings;

public class StringBufferVSStringBuilder {
    public static void main() {
    StringBuffer buffer=new StringBuffer("Buffer");
        System.out.println("Initial Capacity :" +buffer.capacity());
        buffer.append(" Object");
        buffer.insert(0,"Welcome to the world of string classes, ");
        System.out.println( buffer);

        StringBuilder  builder =new StringBuilder();
        StringBuffer data=new StringBuffer();

        Thread t1= new Thread(()-> {
            for (int i = 0; i <1000 ; i++) {
                data.append("A");
            }
        });


        Thread t2= new Thread(()-> {
            for (int i = 0; i <1000 ; i++) {
                data.append("B");
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println(data.length());
    }
}
