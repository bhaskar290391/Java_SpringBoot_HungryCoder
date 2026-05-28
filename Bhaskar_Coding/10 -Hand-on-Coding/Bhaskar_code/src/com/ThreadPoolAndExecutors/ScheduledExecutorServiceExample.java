package com.ThreadPoolAndExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
	public static void main(String[] args) {
		
		ScheduledExecutorService service =Executors.newScheduledThreadPool(1);
		
		service.schedule(new RunnableTask("Task 1"), 3, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(new RunnableTask("Task 2"), 1, 5, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new RunnableTask("Task 3"),1,4,TimeUnit.SECONDS);
		
		service.schedule(()-> {
			service.shutdown();
			System.out.println("Shuting down the scheduler");
		}, 20, TimeUnit.SECONDS);
	}
}
