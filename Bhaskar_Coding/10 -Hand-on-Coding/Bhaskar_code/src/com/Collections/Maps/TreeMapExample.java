package com.Collections.Maps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {

		TreeMap<String, Integer> data = new TreeMap<>();

		data.put("cherry", 3);
		data.put("banana", 2);
		data.put("apple", 1);

		System.out.println(data);

		System.out.println("Accessing the banana value " + data.get("banana"));

		for (Map.Entry<String, Integer> map : data.entrySet()) {
			System.out.println(map.getKey() + " ===>" + map.getValue());
		}

		data.remove("cherry");
		System.out.println(data);

	}
}
