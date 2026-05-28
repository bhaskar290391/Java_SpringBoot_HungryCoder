package com.java8Features.FunctionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

	public static void main(String[] args) {
	
			BinaryOperator<Integer> data= (a,b)-> a+b;
			
			int a=10;
			int b=15;
			int result =data.apply(a, b);
			
			System.out.println("Sum ==>"+ result);
			
			
			
	}

}
