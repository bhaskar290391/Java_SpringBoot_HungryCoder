package com.java8Features.FunctionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryDemo {
	public static void main(String[] args) {
		
		UnaryOperator<Integer> data=number-> number+1;
		
		System.out.println(data.apply(10));
	}
}
