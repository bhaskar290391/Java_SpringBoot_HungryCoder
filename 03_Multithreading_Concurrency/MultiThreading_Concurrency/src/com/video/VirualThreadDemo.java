package com.video;

import java.util.ArrayList;
import java.util.List;

public class VirualThreadDemo {
	public static void main(String[] args) {

		long no_of_Thread = 10000;

		Runnable runnable = () -> {
			System.out.println("Fetching data from  API");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("fetching completed !!!");
		};

		List<Thread> listThread = new ArrayList<>();
		for (int i = 0; i < no_of_Thread; i++) {
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);

			thread.start();

			String threadNumber = "Thread number " + i;
			System.out.println(threadNumber);
			listThread.add(thread);
		}
		
		for (Thread thread : listThread) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
