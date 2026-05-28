package com.Collections.Maps;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {

	public static void main(String[] args) {
		IdentityHashMap<Integer, String> data = new IdentityHashMap<>();

		Integer key1 = new Integer(1);
		Integer key2 = new Integer(1);

		data.put(key1, "one");
		data.put(key2, "one");

		System.out.println(data);

		System.out.println("Accessing key1 " + data.get(key1));
		System.out.println("Accessing key2 " + data.get(key2));
		
		for (Map.Entry<Integer, String> entry : data.entrySet()) {
			System.out.println("The key ==> " + entry.getKey() + " The value ==> " + entry.getValue());

		}
		
		data.remove(key1);
		System.out.println("The data after removal ==>" + data);
	}

}
