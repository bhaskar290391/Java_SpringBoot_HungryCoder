package com.Collections.Lists;

import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector< Integer> data=new Vector<>();
		data.add(1);
		data.add(2);
		data.add(3);
		
		System.out.println("The vector "+ data);
		
		System.out.println(data.get(1));
		
		data.remove(2);
		System.out.println(data);
		
		for (Integer integer : data) {
			System.out.println("The data is "+ integer);
		}

	}

}
