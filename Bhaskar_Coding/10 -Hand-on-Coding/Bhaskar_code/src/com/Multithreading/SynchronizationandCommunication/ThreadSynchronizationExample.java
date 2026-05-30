package com.Multithreading.SynchronizationandCommunication;

class Counter {
	private int counter = 0;

	public synchronized void incrementCounter() {
		counter++;
	}

	public int getCount() {
		return counter;
	}
}

class CounterThread extends Thread {
	Counter counter;

	public CounterThread(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.incrementCounter();
		}
	}
}

public class ThreadSynchronizationExample {
	public static void main(String[] args) {
		Counter c=new Counter();
		CounterThread t1=new CounterThread(c);
		CounterThread t12=new CounterThread(c);
		
		t1.start();
		t12.start();
		
		
		try {
			t1.join();
			t12.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Counter ==> "+ c.getCount());
		
	}
}
