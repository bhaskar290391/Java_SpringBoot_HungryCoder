package com.CoreJava.JavaFeatures;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {
		
		int number[]= {5,3,8,2,9};
		
		//printing an array
		System.out.println("Printing an array "+ Arrays.toString(number));
		
		//sorting an array 
		Arrays.sort(number);
		System.out.println("Printing an array "+ Arrays.toString(number));
		
		//searching an element in arrays
		int element=8;
		System.out.println("Finding an element "+ Arrays.binarySearch(number, element));
		
		//Filled Arrays
		int[] filledArrays=new int[5];
		Arrays.fill(filledArrays, 29);
		System.out.println("Filled Arrays "+ Arrays.toString(filledArrays));
		
		//Copy array 
		int[] copyArrays= Arrays.copyOf(number, number.length);
		System.out.println("Printing an copy arrays array "+ Arrays.toString(copyArrays));
				
	}

}
