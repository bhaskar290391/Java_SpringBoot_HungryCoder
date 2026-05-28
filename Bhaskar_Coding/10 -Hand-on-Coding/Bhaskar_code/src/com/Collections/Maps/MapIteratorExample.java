package com.Collections.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapIteratorExample {

	public static void main(String[] args) {
		// Create a HashMap of String key and Integer value
		HashMap<String, Integer> map = new HashMap<>();

		// Adding elements to the HashMap
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Integer> entry = (Map.Entry<java.lang.String, java.lang.Integer>) iterator
					.next();
			if(entry.getKey().equals("Two")) {
				iterator.remove();
			}
		}
		 System.out.println("Map after removal: " + map); 
		
		 iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Integer> entry = (Map.Entry<java.lang.String, java.lang.Integer>) iterator
					.next();
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}

		
	
	
	}

}
