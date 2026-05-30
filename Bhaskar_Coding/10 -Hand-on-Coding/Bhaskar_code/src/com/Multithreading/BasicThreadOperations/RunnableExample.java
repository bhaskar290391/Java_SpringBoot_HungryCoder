package com.Multithreading.BasicThreadOperations;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread is running using my runnable ");

	}

}

public class RunnableExample {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);

		thread.start();
	}

}
