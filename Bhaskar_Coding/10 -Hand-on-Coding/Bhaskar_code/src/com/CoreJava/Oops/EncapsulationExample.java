package com.CoreJava.Oops;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class EncapsulationExample {

	public static void main(String[] args) {
		Person p = new Person("Bhaskar", 29);
		System.out.println(p.getAge());
		System.out.println(p.getName());

		p.setAge(45);
		System.out.println(p.getAge());

	}

}
