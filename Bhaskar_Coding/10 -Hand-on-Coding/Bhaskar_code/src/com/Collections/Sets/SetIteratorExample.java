package com.Collections.Sets;

import java.util.HashSet;
import java.util.Iterator;

public class SetIteratorExample {
	public static void main(String[] args) {

		HashSet<String> data=new HashSet<>();
		data.add("dog");
		data.add("cat");
		data.add("Elephant");
		
		System.out.println(data);
		
		Iterator<String> iterator = data.iterator();
		
		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println("The data is "+ string);
		}
		 iterator = data.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if(string.equals("cat")) {
				iterator.remove();
			}
		}
		System.out.println("The data is "+ data);
	}
}
