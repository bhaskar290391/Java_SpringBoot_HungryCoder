package com.Collections.Iterators;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIteratorExample {

	public static void main(String[] args) {
		
		Set<String> set= new HashSet<>();
		set.add("apple");
		set.add("banana");
		set.add("cherry");
		set.add("dry fruits");
		
		System.out.println(set);
		
		Iterator<String> data=set.iterator();
		
		while (data.hasNext()) {
			String string = data.next();
			System.out.println(string);
		}

	}

}
