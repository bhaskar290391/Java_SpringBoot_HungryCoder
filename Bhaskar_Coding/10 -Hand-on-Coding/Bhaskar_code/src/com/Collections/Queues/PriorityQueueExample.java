package com.Collections.Queues;

import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		
		PriorityQueue<Integer> data= new PriorityQueue<>();
		data.add(20);
		data.add(5);
		data.add(10);
		
		System.out.println("The in the priority queue" + data);
		
		System.out.println("The top of the queue "+ data.peek());
		
		System.out.println("The polling element ==>" +data.poll());
		
		System.out.println("Element After polling ==>"+ data);
		
		for (Integer integer : data) {
			System.out.println(integer);
		}
	}
}
