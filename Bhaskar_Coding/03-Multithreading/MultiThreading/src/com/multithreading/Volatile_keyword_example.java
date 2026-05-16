package com.multithreading;
class SharedResourceVolatile{
    private volatile boolean flags;

    public boolean isFlags() {
        return flags;
    }

    public void setFlags(boolean flags) {
        this.flags = flags;
    }
}
public class Volatile_keyword_example {


    static void main() {
        SharedResourceVolatile shared=new SharedResourceVolatile();
        Runnable runnable1=()->{
            System.out.println("Thread 1 Started !!!");

            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(5000);
                System.out.println("Thread 1 Logic Completed !!!");
                shared.setFlags(true);
                System.out.println("Updated the Shared Object");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2=()-> {
            System.out.println("Thread 2 started ");
            try{
                System.out.println("Thread 2 logic started");
                while(!shared.isFlags()){

                }

                System.out.println("Thread 2 logic completed");
            }catch (Exception exception){
                throw  new RuntimeException(exception);
            }
        };

        new Thread(runnable1).start();
        new Thread((runnable2)).start();

    }
}
