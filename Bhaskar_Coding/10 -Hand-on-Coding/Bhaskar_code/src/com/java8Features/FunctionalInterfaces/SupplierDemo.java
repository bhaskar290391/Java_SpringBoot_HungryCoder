package com.java8Features.FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		
		Supplier<String> data= ()-> "Hello World";
		
		System.out.println(data.get());
	}
}
