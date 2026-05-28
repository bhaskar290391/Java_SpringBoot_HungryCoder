package com.Collections.Sets;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
	
		TreeSet<Integer> data =new TreeSet<>();
		data.add(10);
		data.add(5);
		data.add(20);
		
		
		System.out.println(data);
		
		System.out.println(data.first());
		
		System.out.println(data.last());
		
		for (Integer integer : data) {
			System.out.println("The data "+ integer);
		}
		
		data.remove(10);
		System.out.println(data);

	}

}
