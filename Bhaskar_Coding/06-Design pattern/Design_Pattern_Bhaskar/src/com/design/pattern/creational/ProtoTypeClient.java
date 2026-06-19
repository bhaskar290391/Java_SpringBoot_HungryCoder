package com.design.pattern.creational;

interface Shape extends Cloneable {
	Shape clones();

	void draw();
}

class Circle implements Shape {

	@Override
	public Shape clones() {

		return new Circle();
	}

	@Override
	public void draw() {
		System.out.println("Circle is drawing");

	}

}

class Rectangle implements Shape {

	@Override
	public Shape clones() {

		return new Rectangle();
	}

	@Override
	public void draw() {
		System.out.println("Rectangle is drawing");

	}

}

public class ProtoTypeClient {
	public static void main(String[] args) {

		Shape circel = new Circle();
		Shape rectangle = new Rectangle();

		Shape clonedCircle = circel.clones();
		Shape clonedRectangle = rectangle.clones();

		clonedCircle.draw();
		clonedRectangle.draw();
	}
}
