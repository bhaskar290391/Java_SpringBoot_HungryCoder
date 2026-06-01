package com.Generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

	public static void printList(List<?> data) {
		for (Object object : data) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
	
	public static double sumOfList(List<? extends Number> data) {
		double sum=0.0;
		for (Number number : data) {
			sum +=number.doubleValue();
		}
		
		return sum;
	}

	public static void main(String[] args) {

		List<Integer> integerData = new ArrayList<>();
		integerData.add(10);
		integerData.add(20);
		integerData.add(30);
		System.out.println("Printing Integer Data :");
		printList(integerData);

		List<Double> doubleData = new ArrayList<>();
		doubleData.add(10.1);
		doubleData.add(20.2);
		doubleData.add(30.3);
		System.out.println("Printing Double Data :");
		printList(doubleData);
		
		System.out.println("Sum of all integer "+ sumOfList(integerData));
		
		System.out.println("Sum of all integer "+ sumOfList(doubleData));

	}

}
