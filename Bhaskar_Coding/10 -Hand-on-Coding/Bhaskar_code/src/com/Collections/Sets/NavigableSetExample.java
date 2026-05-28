package com.Collections.Sets;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {

	public static void main(String[] args) {

		NavigableSet<String> data = new TreeSet<>();
		data.add("apple");
		data.add("banana");
		data.add("cherry");
		data.add("date");

		System.out.println("The data is" + data);

		System.out.println(data.first());
		System.out.println(data.last());

		System.out.println(data.lower("banana"));
		System.out.println(data.higher("banana"));

		for (String string : data) {
			System.out.println("The data is for iterating" + string);
		}

		data.remove("cherry");
		System.out.println(data);

	}

}
