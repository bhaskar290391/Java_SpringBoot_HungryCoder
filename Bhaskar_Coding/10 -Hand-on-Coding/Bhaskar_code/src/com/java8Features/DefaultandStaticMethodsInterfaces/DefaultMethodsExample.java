package com.java8Features.DefaultandStaticMethodsInterfaces;

interface MyInterface{
	
	public void existingMethod(String str);
	
	default void defaultMethod() {
		System.out.println("I am default method");
	}
}

class MyClass implements MyInterface{

	@Override
	public void existingMethod(String str) {
		System.out.println("The value of the string ==>"+ str);
		
	}
	
	@Override
	public void defaultMethod() {
		System.out.println("I am overriding version of default method");
	}
	
}
public class DefaultMethodsExample {

	public static void main(String[] args) {
		
		MyClass test=new MyClass();
		test.existingMethod("bhaskar");
		test.defaultMethod();
	}

}
