package com.java8Features.FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> prefix=str-> System.out.println("Prefix : "+str);
		
		String str="Hello World";
		prefix.accept(str);
	}
}
