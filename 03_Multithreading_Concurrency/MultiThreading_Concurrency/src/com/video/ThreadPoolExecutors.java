package com.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutors {
	public static void main(String[] args) {

		System.out.println("Thread pool ");
		ExecutorService thread = new ThreadPoolExecutor(1, 5, 0l, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2));
		for (int i = 1; i < 6; i++) {
			final int taskId = i;
			thread.execute(() -> {
				System.out.println(
						"ThreadPoolExecutor Thread Task " + taskId + " is executed by Thread " + Thread.currentThread().getName());
			});
		}
		thread.shutdown();
	}
}
