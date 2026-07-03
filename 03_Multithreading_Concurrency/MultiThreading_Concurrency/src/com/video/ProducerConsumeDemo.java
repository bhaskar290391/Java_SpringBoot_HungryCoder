package com.video;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerQueue implements Runnable {

	private BlockingQueue<Integer> queue;

	public ProducerQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {

			try {
				Thread.sleep(1000);
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produce " + i);
		}

	}

}

class ConsumerQueue implements Runnable {

	private BlockingQueue<Integer> queue;

	public ConsumerQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			Integer take;
			try {
				take = queue.take();
				System.out.println("Consumed ==> " + take);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class ProducerConsumeDemo {
	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

		ProducerQueue pq = new ProducerQueue(queue);
		ConsumerQueue cq = new ConsumerQueue(queue);

		Thread producer = new Thread(pq);
		Thread consumer = new Thread(cq);

		producer.start();
		consumer.start();
	}
}
