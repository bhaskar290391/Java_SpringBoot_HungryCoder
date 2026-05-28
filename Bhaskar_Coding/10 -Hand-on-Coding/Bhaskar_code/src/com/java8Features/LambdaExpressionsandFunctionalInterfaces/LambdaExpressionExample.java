package com.java8Features.LambdaExpressionsandFunctionalInterfaces;

@FunctionalInterface
interface GreetingService {
	void sayHello(String input);
}

public class LambdaExpressionExample {
	public static void main(String[] args) {
		GreetingService service1=msg-> System.out.println("Hello "+msg);
		
		GreetingService service2=msg->{
			System.out.println("Hello " + msg);
			System.out.println("Welcome to the java lambda expression");
		};
		
		service1.sayHello("bhaskar");
		service2.sayHello("sammy");
		
	}
}
