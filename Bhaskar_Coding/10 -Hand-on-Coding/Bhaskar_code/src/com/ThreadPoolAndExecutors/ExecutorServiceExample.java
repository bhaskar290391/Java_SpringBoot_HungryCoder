package com.ThreadPoolAndExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		ExecutorService service =Executors.newSingleThreadExecutor();
		
		Callable<String> callable =new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				Thread.sleep(15000);
				return "Callable result completed";
			}
		};
		
		Future<String> future=service.submit(callable);
		
		try {
			String data =future.get();
			System.out.println("The result of future ==>"+ data);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		service.shutdown();

	}

}
