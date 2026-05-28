package com.Collections.Maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) {

		Map<String, Integer> data = new WeakHashMap<>();

		String key1 = new String("apple");
		String key2 = new String("banana");
		
		data.put(key1, 1);
		data.put(key2, 2);
		
		System.out.println(data);
		
		System.out.println("Accessing the value ==>"+ data.get(key2));
		
		key1=null;
		key2=null;
		
		System.gc();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(data);

	}

}
