package com.Collections.Iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapIteratorExample {

	public static void main(String[] args) {

		Map<String, Integer> data = new HashMap<>();
		data.put("one", 1);
		data.put("two", 2);
		data.put("three", 3);
		data.put("four", 4);
		data.put("five", 5);

		System.out.println(data);

		Iterator<Entry<String, Integer>> iterator = data.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Integer> entry = iterator.next();
			System.out.println("The key "+ entry.getKey() +" the values "+ entry.getValue());
		}
	}

}
