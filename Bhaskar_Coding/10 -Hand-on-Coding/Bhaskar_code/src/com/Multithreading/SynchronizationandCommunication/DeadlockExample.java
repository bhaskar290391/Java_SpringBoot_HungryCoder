package com.Multithreading.SynchronizationandCommunication;

class Resources {

	public synchronized void method1(Resources resources) {
		System.out.println(Thread.currentThread().getName() + "is running");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resources.method2(this);

	}

	public synchronized void method2(Resources resources) {

		System.out.println(Thread.currentThread().getName() + "is running");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resources.method1(this);

	}

}

public class DeadlockExample {

	public static void main(String[] args) {

		Resources resources1 = new Resources();
		Resources resources2 = new Resources();

		Thread t1 = new Thread(() -> resources1.method1(resources2), "Thread -1");
		Thread t2 = new Thread(() -> resources2.method1(resources1), "Thread -2");

		t1.start();
		t2.start();
	}

}
