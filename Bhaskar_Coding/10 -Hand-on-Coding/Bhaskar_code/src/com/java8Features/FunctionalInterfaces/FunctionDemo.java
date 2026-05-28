package com.java8Features.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		
		Function<String, Integer> data= str-> str.length();
		String test="Bhaskar Mudaliyar";
		
		System.out.println("The length of String "+ data.apply(test));
	}
}
