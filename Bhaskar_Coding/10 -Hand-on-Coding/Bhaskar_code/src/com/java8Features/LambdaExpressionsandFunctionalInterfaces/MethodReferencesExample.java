package com.java8Features.LambdaExpressionsandFunctionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class MethodReferencesExample {
	public static void message(String data) {
		System.out.println(data);
	}

	public static void main(String[] args) {
		List<String> messages = Arrays.asList("Hello", "World", "Method", "References", "in", "Java");

		messages.forEach(MethodReferencesExample:: message);
		
		messages.forEach(String::toUpperCase);
	}

}
