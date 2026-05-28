package com.Collections.Maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapExample {

	public static void main(String[] args) {
		
		NavigableMap<String, Integer> data=new TreeMap<>();
		
		data.put("apple", 1);
		data.put("banana", 2);
		data.put("cherry", 3);
		data.put("date", 4);
		
		System.out.println(data);
		
		System.out.println(data.firstEntry());
		System.out.println(data.lastEntry());
		
		
		System.out.println(data.lowerEntry("banana"));
		System.out.println(data.higherEntry("banana"));
		

		for (Map.Entry<String, Integer> map : data.entrySet()) {
			System.out.println(map.getKey() + " ===>" + map.getValue());
		}

		data.remove("cherry");
		System.out.println(data);

	}

}
