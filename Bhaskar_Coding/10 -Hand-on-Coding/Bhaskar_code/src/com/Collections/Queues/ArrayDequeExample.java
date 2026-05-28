package com.Collections.Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayDeque<Integer> deque = new ArrayDeque<>();

		deque.addFirst(1);
		deque.addLast(2);
		deque.addFirst(0);

		System.out.println(deque);

		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());

		deque.removeFirst();
		deque.removeLast();

		System.out.println("The data after removal of element " + deque);

		for (Integer integer : deque) {
			System.out.println("The element is " + integer);
		}
	}

}
