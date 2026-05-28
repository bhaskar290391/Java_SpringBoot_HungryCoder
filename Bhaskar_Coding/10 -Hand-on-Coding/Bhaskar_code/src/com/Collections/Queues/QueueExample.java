package com.Collections.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {

		Queue<String> data = new LinkedList<>();

		data.add("A");
		data.add("B");
		data.add("C");

		System.out.println(data);

		System.out.println(data.peek());

		data.remove();

		System.out.println("Queue after removal" + data);
		
		String polledElement=data.poll();
		System.out.println("The polled element ==>"+polledElement);
		
		System.out.println("After pooling the element ==>"+ data);
		
		
		for (String string : data) {
			System.out.println("The remaining element "+ string);
		}
		

	}

}
