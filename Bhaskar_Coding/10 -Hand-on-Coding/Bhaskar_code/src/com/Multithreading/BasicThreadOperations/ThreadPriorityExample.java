package com.Multithreading.BasicThreadOperations;

class MyPriority extends Thread {
	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " running with priority "
				+ Thread.currentThread().getPriority());
	}
}

public class ThreadPriorityExample {
	public static void main(String[] args) {

		MyPriority t1 = new MyPriority();
		MyPriority t2 = new MyPriority();
		MyPriority t3 = new MyPriority();

		t1.setName("bhaskar");
		t2.setName("kanishk");
		t3.setName("sammy");

		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
	}
}
