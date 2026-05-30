package com.Multithreading.SynchronizationandCommunication;

class Shared {
	private boolean ready = false;

	public synchronized void produce() {
		ready = true;
		System.out.println("Produced Data");
		notifyAll();
	}

	public synchronized void consumer() {
		while (ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Consumed Data");
	}
}

public class NotifyAllExample {

	public static void main(String[] args) {
		Shared data = new Shared();
		// TODO Auto-generated method stub
		Thread t1 = new Thread(() -> {
			data.consumer();
		});
		Thread t2 = new Thread(() -> {
			data.consumer();
		});
		Thread t3 = new Thread(() -> {
			data.produce();
		});

		t1.start();
		t2.start();
		t3.start();

	}

}
