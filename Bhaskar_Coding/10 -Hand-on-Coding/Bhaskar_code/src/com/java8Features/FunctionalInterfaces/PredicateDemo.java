package com.java8Features.FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		
		Predicate<Integer> checkGreaterThan15=number-> number >15;
		
		Integer number=9;
		
		if(checkGreaterThan15.test(number)) {
			System.out.println("Greater than 15");
		}else {
			System.out.println("Lesser than 15");
		}
	}
}
