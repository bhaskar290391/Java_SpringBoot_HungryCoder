package com.Collections.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIteratorExample {

	public static void main(String[] args) {
		List<Integer> data=new ArrayList<>();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);

		System.out.println(data);
		
		Iterator<Integer> iterator = data.iterator();
		
		while (iterator.hasNext()) {
			Integer integer = iterator.next();
			
			System.out.println("The element  "+ integer);
			
			if(integer==4) {
				data.add(6);
			}
		}
	}

}
