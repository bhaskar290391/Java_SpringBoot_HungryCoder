package com.CoreJava.JavaFeatures;

public class FinalKeywordExample {

	final int data = 100;

	public final void finalMethod() {
		System.out.println("Inside the final method");
	}

	public static void main(String[] args) {
		FinalKeywordExample data = new FinalKeywordExample();
		System.out.println("Data ==>" + data.data);

		data.finalMethod();
	}

}

/*
 * class ChildClass extends FinalKeywordExample{
 * 
 * @Override public final void finalMethod() {
 * System.out.println("Inside the final method"); } }
 */
