package com.Multithreading.SynchronizationandCommunication;

class SharedResources {
	private boolean available = false;

	public synchronized void produce() {
		
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Produced !!!");
		available=true;
		notify();
	}

	public synchronized void consume() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consumed !!!");
		available=false;
		notify();
	}

	

}

class Producer extends Thread {
	private SharedResources resources;

	public Producer(SharedResources resources) {
		this.resources = resources;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			resources.produce();
		}

	}

}

class Consumer extends Thread {
	private SharedResources resources;

	public Consumer(SharedResources resources) {
		this.resources = resources;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			resources.consume();
		}

	}

}

public class ThreadCommunicationExample {
	public static void main(String[] args) {

		SharedResources resources = new SharedResources();
		Producer producer = new Producer(resources);
		Consumer consumer = new Consumer(resources);

		producer.start();
		consumer.start();
	}
}
