package com.CoreJava.Oops;

public class ConstructorOverloadingExample {

	private int id;
	private String name;

	public ConstructorOverloadingExample() {
		this.id = 0;
		this.name = "Sammy";
	}

	public ConstructorOverloadingExample(int id) {

		this.id = id;
		this.name = "Bhaskar";
	}

	public ConstructorOverloadingExample(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void display() {
		System.out.println("Id : " + id + " Name : " + name);
	}

	public static void main(String[] args) {

		ConstructorOverloadingExample obj1 = new ConstructorOverloadingExample();
		ConstructorOverloadingExample obj2 = new ConstructorOverloadingExample(20);
		ConstructorOverloadingExample obj3 = new ConstructorOverloadingExample(10, "Kanishk");

		obj1.display();
		obj2.display();
		obj3.display();

	}

}
