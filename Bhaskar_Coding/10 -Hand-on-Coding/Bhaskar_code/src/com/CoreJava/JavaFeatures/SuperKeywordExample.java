package com.CoreJava.JavaFeatures;

class Parent {

	public Parent() {
		System.out.println("parent customer class");
	}

	public void display() {
		System.out.println("Inside parent class method");
	}
}

public class SuperKeywordExample extends Parent {

	public SuperKeywordExample() {
		super();
		System.out.println("Inside the SuperKeywordExample Constructor");
	}

	public void display() {
		super.display();
		System.out.println("SuperKeywordExample : method");
	}

	public static void main(String[] args) {
		SuperKeywordExample data = new SuperKeywordExample();
		data.display();
	}
}
