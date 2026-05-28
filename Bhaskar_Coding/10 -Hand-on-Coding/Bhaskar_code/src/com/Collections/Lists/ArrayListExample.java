package com.Collections.Lists;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> data=new ArrayList<>();
		data.add("apple");
		data.add("banana");
		data.add("cherry");
		
		System.out.println(data);
		
		System.out.println(data.get(1));
		
		data.remove("banana");
		
		System.out.println("Data after removing banana "+ data);
		
		
		for (String string : data) {
			System.out.println("The fruits ==> "+ string);
		}
		
		
	}

}
