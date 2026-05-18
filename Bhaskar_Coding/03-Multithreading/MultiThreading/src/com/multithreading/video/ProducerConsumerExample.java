package com.multithreading.video;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

class ProducerBlockingQueue implements Runnable{

    private BlockingQueue queue;
    public ProducerBlockingQueue(BlockingQueue queue) {
        this.queue =queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1000);
                queue.put(i);
                System.out.println("Produced the Item and added in the blocking queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerBlocingQueue implements  Runnable{

    private BlockingQueue queue;

    public ConsumerBlocingQueue(BlockingQueue queue) {
    this.queue=queue;
    }

    @Override
    public void run() {
    while (true){
        try {
            queue.take();
            System.out.println("Consumer Consumed Item");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    }
}
public class ProducerConsumerExample {
    static void main() {
        BlockingQueue queue =new ArrayBlockingQueue(5);

        ProducerBlockingQueue producer =new ProducerBlockingQueue(queue);
        ConsumerBlocingQueue consumer= new ConsumerBlocingQueue(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
