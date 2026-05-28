package com.ThreadPoolAndExecutors;

public class RunnableTask implements Runnable {

	String taskName;

	public RunnableTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " started " + taskName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end " + taskName);

	}

}
