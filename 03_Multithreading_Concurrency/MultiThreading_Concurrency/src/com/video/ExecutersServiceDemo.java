package com.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutersServiceDemo {
	public static void main(String[] args) {

		System.out.println("Single Thread executers service");
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 1; i < 6; i++) {
			final int taskId = i;
			newSingleThreadExecutor.execute(() -> {
				System.out.println(
						"Single thread Task " + taskId + " is executed by Thread " + Thread.currentThread().getName());
			});
		}
		newSingleThreadExecutor.shutdown();

		System.out.println("New Fixed pool Thread executers service");
		ExecutorService newfixedThreadExecutor = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 6; i++) {
			final int taskId = i;
			newfixedThreadExecutor.execute(() -> {
				System.out.println("New Fixedthread Task " + taskId + " is executed by Thread "
						+ Thread.currentThread().getName());
			});
		}
		newfixedThreadExecutor.shutdown();

		System.out.println("cached pool Thread executers service");
		ExecutorService newCachedFixedPool = Executors.newCachedThreadPool();
		for (int i = 1; i < 6; i++) {
			final int taskId = i;
			newCachedFixedPool.execute(() -> {
				System.out.println(
						"cached Thread Task " + taskId + " is executed by Thread " + Thread.currentThread().getName());
			});
		}
		newCachedFixedPool.shutdown();
		
		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
		for (int i = 1; i < 6; i++) {
			final int taskId = i;
			newScheduledThreadPool.schedule(() -> {
				System.out.println(
						"newScheduledThreadPool Thread Task " + taskId + " is executed by Thread " + Thread.currentThread().getName());
			}, 3, TimeUnit.SECONDS);
		}
		newScheduledThreadPool.shutdown();
	}
}
