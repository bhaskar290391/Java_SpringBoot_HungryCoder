package com.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();

		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Callable task result";
			}
		};

		Future<String> data = service.submit(callable);

		try {
			String future = data.get();
			System.out.println("The result of the callable : " + future);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		service.shutdown();
	}
}
