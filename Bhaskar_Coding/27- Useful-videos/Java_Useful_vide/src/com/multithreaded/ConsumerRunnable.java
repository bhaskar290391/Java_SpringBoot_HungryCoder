package com.multithreaded;

import java.util.concurrent.BlockingQueue;

public class ConsumerRunnable implements  Runnable{

    BlockingQueue<Integer> blockingQueue;

    public ConsumerRunnable(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer take = blockingQueue.take();
                System.out.println("Consumer Consumed the Data !!!" +take);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
