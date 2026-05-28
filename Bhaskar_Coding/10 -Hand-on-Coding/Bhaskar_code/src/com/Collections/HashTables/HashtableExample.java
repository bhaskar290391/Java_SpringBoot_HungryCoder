package com.Collections.HashTables;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class HashtableExample {
	public static void main(String[] args) {
		
		Hashtable<String, Integer> data=new Hashtable<>();
		data.put("one", 1);
		data.put("two", 2);
		data.put("three", 3);
		data.put("four", 4);
		
		System.out.println(data);
		
		//get value by key
		System.out.println(data.get("two"));
		
		//remove object by key and display
		data.remove("three");
		System.out.println(data);
		
		//Iterating oevr enumeration
		Enumeration<String> keys = data.keys();
		while (keys.hasMoreElements()) {
			String string = (String) keys.nextElement();
			System.out.println("The key is "+ string +" the value is "+data.get(string));
		}
		
		//iterating over entryset
		Set<Entry<String, Integer>> entrySet = data.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println("key ==> "+entry.getKey()+" values==> "+entry.getValue());
		}
	}
}
