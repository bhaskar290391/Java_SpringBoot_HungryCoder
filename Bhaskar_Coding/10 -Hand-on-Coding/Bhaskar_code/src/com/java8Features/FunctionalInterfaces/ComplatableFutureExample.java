package com.java8Features.FunctionalInterfaces;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplatableFutureExample {
	public static void main(String[] args) {
		
		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(()->{
			System.out.println("Running Asynch task from completable feature");
		});
		
		try {
			runAsync.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<String> supply = CompletableFuture.supplyAsync(()->{
			return "Returning from Supply Synch Completable feature";
		});
		
		try {
			String data=supply.get();
			System.out.println(data);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
			return "Hello";
		});
		
		
		
		CompletableFuture<String> world = CompletableFuture.supplyAsync(()->{
			return "World";
		});
		
		CompletableFuture<String> combine = hello.thenCombine(world, (str,str2)-> {
			return str+ " ==> "+ str2;
		});
		
		try {
			String data=combine.get();
			System.out.println(data);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(()->{
			if(true) {
				throw new RuntimeException("Exception is thrown");
			}
			return "Will not return anything";
		}).exceptionally(exception->{
			  System.out.println("Exception: " + exception.getMessage());
			  return "Exception return";
		});
		
		try {
			String data =exceptionally.get();
			System.out.println(data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
