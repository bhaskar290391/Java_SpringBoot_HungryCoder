package com.Collections.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

	public static void main(String[] args) {

		Map<Integer, String> data = new LinkedHashMap<>();

		data.put(1, "one");
		data.put(2, "two");
		data.put(3, "three");

		System.out.println(data);

		System.out.println(data.get(2));

		for (Map.Entry<Integer, String> entry : data.entrySet()) {
			System.out.println("The key ==> " + entry.getKey() + " The value ==> " + entry.getValue());

		}
		
		data.remove(3);
		
		System.out.println("After the Remove ==>"+data);

	}

}
