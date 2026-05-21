package com.multithreaded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    static void main() {

        BlockingQueue<Integer> blockingQueue =new ArrayBlockingQueue(3);

        ProducerRunnable producerRunnable=new ProducerRunnable(blockingQueue);
        ConsumerRunnable consumerRunnable=new ConsumerRunnable(blockingQueue);

        Thread producer=new Thread(producerRunnable);
        Thread consumer=new Thread(consumerRunnable);

        producer.start();
        consumer.start();
    }
}
