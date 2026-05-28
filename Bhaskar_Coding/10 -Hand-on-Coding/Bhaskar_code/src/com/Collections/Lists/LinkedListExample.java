package com.Collections.Lists;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> animals = new LinkedList<>();
		animals.add("dog");
		animals.add("cat");
		animals.add("birds");

		System.out.println(animals);

		System.out.println(animals.getFirst());
		System.out.println(animals.getLast());

		animals.remove("cat");

		System.out.println(animals);

		for (String string : animals) {
			System.out.println("The animals ==> " + string);
		}
	}

}
