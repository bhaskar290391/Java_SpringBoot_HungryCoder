package com.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

	public static void main(String[] args) {

		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Future task result";
			}
		};

		FutureTask<String> futureTask = new FutureTask<>(callable);

		ExecutorService service = Executors.newSingleThreadExecutor();

		service.submit(futureTask);

		try {
			String result = futureTask.get();
			System.out.println("The result is " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.shutdown();

	}

}
