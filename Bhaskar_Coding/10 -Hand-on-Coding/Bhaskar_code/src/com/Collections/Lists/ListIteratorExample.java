package com.Collections.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {

		ArrayList<String> cities = new ArrayList<>();

		cities.add("New York");
		cities.add("Los Angeles");
		cities.add("Chicago");

		ListIterator<String> iterator = cities.listIterator();

		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println("Forwarding data ==> "+ string);
		}
		
		

		while (iterator.hasPrevious()) {
			String string = (String) iterator.previous();
			System.out.println("backwording data ==> "+ string);
		}
		
		while (iterator.hasNext()) {
			String string = iterator.next();

			if (string.equals("Los Angeles")) {
				iterator.set("San Francisco");
			}
		}

		System.out.println(cities);
		
		
		

	}

}
