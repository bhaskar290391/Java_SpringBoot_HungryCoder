package com.java8Features.LambdaExpressionsandFunctionalInterfaces;

@FunctionalInterface
interface MathOperation {
	public int operation(int a, int b);
}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		MathOperation add = (a, b) -> a + b;
		MathOperation sub = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> a * b;
		MathOperation divide = (a, b) -> a / b;

		System.out.println(add.operation(3, 2));
		System.out.println(sub.operation(3, 2));
		System.out.println(multiply.operation(3, 2));
		System.out.println(divide.operation(3, 2));

	}

}
