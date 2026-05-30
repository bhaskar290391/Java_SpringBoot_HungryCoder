package com.CoreJava.Oops;

abstract class Animals {

	private String name;

	public Animals(String name) {
		this.name = name;
	}

	void sleep() {
		System.out.println(name + " is sleeping !!!");
	}

	abstract void sound();
}

interface Pet {

	public void play();

	default void beHappy() {
		System.out.println("Pet is happy");
	}

	public static void showAffection() {
		System.out.println("Pet is showing Affection");
	}
}

class MyAnimal extends Animals implements Pet {

	public MyAnimal(String name) {
		super(name);
	}

	@Override
	public void play() {
		System.out.println("Dog is playing");

	}

	@Override
	void sound() {
		System.out.println("Dog is playing sound");

	}

}

public class AbstractVsInterfaceExample {

	public static void main(String[] args) {
		MyAnimal animal = new MyAnimal("maddy");
		animal.beHappy();
		animal.sleep();
		animal.sound();

		Pet.showAffection();

	}

}
