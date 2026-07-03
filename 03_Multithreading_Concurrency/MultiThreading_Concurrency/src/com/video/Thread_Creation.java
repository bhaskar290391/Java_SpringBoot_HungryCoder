package com.video;

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Child Thread");
	}
}

public class Thread_Creation {
	public static void main(String[] args) {

		System.out.println("Main Thread is started");
		MyThread t = new MyThread();
		t.start();

		Runnable runnable = () -> {
			System.out.println("Thread 2 is running");
		};

		Thread thread2 = new Thread(runnable);
		thread2.start();

		Thread thread3 = new Thread(() -> {
			System.out.println("Thread 3 is started");
		});

		thread3.start();

		System.out.println("Main Thread is completed");
	}
}
