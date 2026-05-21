package com.multithreaded;
class SharedResourse{
    private volatile boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class VolatileExample {
    static void main() {
        SharedResourse resource=new SharedResourse();

        Runnable runnable1= ()->{
            System.out.println("Thread 1 started ");
            try{
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                resource.setFlag(true);
                System.out.println("Thread 1 Updated the Flag");
            }catch (InterruptedException exception){
                throw  new RuntimeException("Exception thrown");
            }
        };

        Runnable runnable2= ()->{
            System.out.println("Thread 2 started ");
           while (!resource.isFlag()){

           }
            System.out.println("Thread 2 Completed !!!");
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
