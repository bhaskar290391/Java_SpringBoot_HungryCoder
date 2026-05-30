package com.CoreJava.Oops;

class Car {

	public void sound() {
		System.out.println("Car is Making sound");
	}

}

class Maruthi extends Car {
	@Override
	public void sound() {
		System.out.println("Maruthi is Making sound");
	}
}

public class PolymorphismExample {
	public static void main(String[] args) {

		Car car=new Maruthi();
		car.sound();
	}
}
