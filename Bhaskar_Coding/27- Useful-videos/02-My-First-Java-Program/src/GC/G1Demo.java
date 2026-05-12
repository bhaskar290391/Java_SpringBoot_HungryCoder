package GC;

public class G1Demo {
    public static void main(String[] args) throws InterruptedException {

        //java -XX:+PrintGCDetails -Xmx256m GC.G1Demo > GC/gcLogs.txt
        for (int i = 0; i <100000 ; i++) {
            Object obj=new Object();
        }

        System.gc();
        Thread.sleep(5000);

        byte[] data=new byte[150*1024*1024];

        for (int i = 0; i <5000 ; i++) {
            Object obj=new Object();
        }

        System.gc();
    }
}
