package com.CoreJava.Oops;

public class ClassAndObjectsExample {

	private int id;
	private String name;

	public ClassAndObjectsExample(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void display() {
		System.out.println("Id :" + id + " ==>Name :" + name);
	}

	public static void main(String[] args) {

		ClassAndObjectsExample obj = new ClassAndObjectsExample(29, "bhaskar");
		obj.display();
	}

}
