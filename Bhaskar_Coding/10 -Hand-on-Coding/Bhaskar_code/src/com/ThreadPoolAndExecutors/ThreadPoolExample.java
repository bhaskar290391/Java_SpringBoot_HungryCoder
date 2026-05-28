package com.ThreadPoolAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 6; i++) {
			RunnableTask task = new RunnableTask("Task " + i);
			service.execute(task);
		}

		service.shutdown();

		while (!service.isTerminated()) {

		}

		System.out.println("All the job is completed successfully");

	}

}
