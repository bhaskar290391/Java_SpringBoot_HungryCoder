package com.video;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
	// private int count = 0;

	private AtomicInteger count = new AtomicInteger(0);

	public int getCount() {
		return count.get();
	}

	public void incrementCount() {
		this.count.incrementAndGet();
	}

}

public class AtomicExample {
	public static void main(String[] args) throws InterruptedException {

		SharedCounter object = new SharedCounter();
		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 50000; i++) {
				object.incrementCount();
			}
		});

		Thread t2 = new Thread(() -> {

			for (int i = 0; i < 50000; i++) {
				object.incrementCount();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("The object count ==> " + object.getCount());
	}
}
