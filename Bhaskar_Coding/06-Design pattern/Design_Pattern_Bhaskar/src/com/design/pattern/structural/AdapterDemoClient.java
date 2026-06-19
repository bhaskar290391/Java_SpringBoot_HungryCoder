package com.design.pattern.structural;

import java.awt.Shape;

interface Shapee {
	void draw();
}

//adaptee class 
class Rectangles {
	public void drawing() {
		System.out.println("Drawing");
	}
}

//adapter class
class RectangleAdapter implements Shapee {
	private Rectangles rectangles;

	public RectangleAdapter(Rectangles rectangles) {
		this.rectangles = rectangles;
	}

	@Override
	public void draw() {
		rectangles.drawing();
	}

}

public class AdapterDemoClient {
	public static void main(String[] args) {

		Rectangles rect = new Rectangles();
		RectangleAdapter adapter = new RectangleAdapter(rect);
		adapter.draw();
	}
}
