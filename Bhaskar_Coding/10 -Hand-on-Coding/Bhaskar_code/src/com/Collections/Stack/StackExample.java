package com.Collections.Stack;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Integer> data = new Stack<>();
		data.push(10);
		data.push(20);
		data.push(30);
		data.push(40);

		System.out.println("The stack ==>" + data);

		System.out.println(data.peek());

		System.out.println("The pop element ==> " + data.pop());
		System.out.println("The pop element ==> " + data.pop());

		System.out.println("The element After poping " + data);

		if (data.isEmpty()) {
			System.out.println("The stack is empty");
		} else {
			System.out.println("The satck is not empty");
		}
		
		int position=data.search(10);
		
		if(position !=-1) {
			System.out.println("Element Found");
		}else {
			System.out.println("Element Not found");
		}
	}

}
