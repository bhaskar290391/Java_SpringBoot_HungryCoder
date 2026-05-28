package com.Collections.Iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		  List<Integer> list = new ArrayList();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        list.add(4);
	        list.add(5);
	        
	        
	        ListIterator<Integer> listIterator = list.listIterator();
	        
	        while (listIterator.hasNext()) {
				Integer integer =  listIterator.next();
				System.out.println("The forwarding List >>" + integer);
			}
	        
	        System.out.println();
	        while (listIterator.hasPrevious()) {
				Integer integer =  listIterator.previous();
				System.out.println("The backwording List >>" + integer);
			}

	}

}
