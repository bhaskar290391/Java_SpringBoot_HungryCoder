package com.Multithreading.SynchronizationandCommunication;

class Message {
	private String message;

	public synchronized void produce(String message) {
		this.message = message;
		System.out.println("Produced ==> " + message);
		notify();
	}

	public synchronized void consume() {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Consumed : " + message);

	}
}

public class WaitNotifyExample {
	public static void main(String[] args) {
		Message mesg=new Message();
		
		Thread producer=new Thread(()-> {
			mesg.produce("Hello Bhaskar");
		});
		
		Thread consumer= new Thread(()-> {
			mesg.consume();
		});
		
		producer.start();
		consumer.start();
	}
}
