package com.multithreaded;

import java.util.concurrent.BlockingQueue;

public class ProducerRunnable implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;
    public ProducerRunnable(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(2000);
                blockingQueue.add(i);
                System.out.println("Produced produced the data");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
