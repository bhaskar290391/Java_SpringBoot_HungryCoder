package com.Multithreading.BasicThreadOperations;

class MyLifecycleThread extends Thread {
	@Override
	public void run() {

		System.out.println("Thread start running");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
		}

		System.out.println("Thread is terminated");
	}
}

public class ThreadLifecycleExample {

	public static void main(String[] args) {

		MyLifecycleThread thread = new MyLifecycleThread();
		thread.start();

		System.out.println("Current state of thread ==>" + thread.getState());

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("State of Thread ==>" + thread.getState());
	}

}
