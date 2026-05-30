package com.CoreJava.Oops;

public class MethodOverloadingExample {

	public void display(String name) {
		System.out.println("Name : " + name);
	}

	public void display(String name, int age) {
		System.out.println("Name : " + name + "  age: " + age);
	}

	public static void main(String[] args) {

		MethodOverloadingExample obj =new MethodOverloadingExample();
		obj.display("bhaskar");
		obj.display("sammy", 29);
	}
}
