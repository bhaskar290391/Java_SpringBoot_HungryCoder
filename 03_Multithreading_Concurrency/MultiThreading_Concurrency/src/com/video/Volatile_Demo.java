package com.video;

class SharedObject {
	private volatile boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

public class Volatile_Demo {
	static SharedObject object =new SharedObject();
	public static void main(String[] args) {
		
		new Thread(()->{
			System.out.println("Thread 1 started !!!");
			
			try {
				System.out.println("Thread 1 logic started");
				Thread.sleep(3000);
				System.out.println("Thread 1 logic completed");
				object.setFlag(true);
			} catch (InterruptedException e) {
				throw new RuntimeException("Interrupted");
			}
		}).start();
		
		
		new Thread(()->{
			System.out.println("Thread 2 started !!!");
			
			while(!object.isFlag()) {
				
			}
			System.out.println("Thread 2 completd");
		}).start();
	}
}
