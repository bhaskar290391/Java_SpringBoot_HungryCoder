package com.video;

public class ThreadLocalDemo {
	public static void main(String[] args) {

		ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

		long userId1 = 1246l;
		long userId2 = 45487l;

		Thread t1 = new Thread(() -> {
			System.out.println("Thread1 started ");
			userIdThreadLocal.set(userId1);
			System.out.println("Thread1 completed the logic");

			System.out.println("Thread1 Thread local ==>" + userIdThreadLocal.get());
			userIdThreadLocal.remove();
			System.out.println("Removed Thread local ==>" + userIdThreadLocal.get());
		});
		
		
		Thread t2 = new Thread(() -> {
			System.out.println("Thread2 started ");
			userIdThreadLocal.set(userId1);
			System.out.println("Thread2 completed the logic");

			System.out.println("Thread2 Thread local ==>" + userIdThreadLocal.get());
			userIdThreadLocal.remove();
			System.out.println("Removed Thread local of thread2==>" + userIdThreadLocal.get());
		});

		t1.start();
		t2.start();
		
		
		Thread thread3=new Thread(()->{
			
			inheritableThreadLocal.set("instagram");
			userIdThreadLocal.set(1245554l);
			
			Thread thread4=new Thread(()->{
				System.out.println(inheritableThreadLocal.get());
				System.out.println(userIdThreadLocal.get());
			});
			
			thread4.start();
		}) ;
		
		thread3.start();
	}
}
