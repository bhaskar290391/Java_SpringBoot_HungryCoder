package com.java8Features.DefaultandStaticMethodsInterfaces;

interface MyStaticInterface{
	public static void staticMethod() {
		System.out.println("I am static method of interface");
	}
	public void dataSet();
}

class MyStaticClass implements MyStaticInterface{

	@Override
	public void dataSet() {
		System.out.println("I am instance method of MyStaticClass");
		
	}
	
}


public class StaticMethodsInInterfaceExample {

	public static void main(String[] args) {
		MyStaticClass test=new MyStaticClass();
		test.dataSet();
		
		MyStaticInterface.staticMethod();

	}

}
