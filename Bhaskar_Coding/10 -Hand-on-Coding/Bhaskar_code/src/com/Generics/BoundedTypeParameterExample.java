package com.Generics;

class NumberBox<T extends Number> {
	private T content;

	public NumberBox(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public double getDoubleContent() {
		return content.doubleValue();
	}

}

public class BoundedTypeParameterExample {

	public static void main(String[] args) {

		NumberBox<Integer> intData = new NumberBox<>(123);
		System.out.println(intData.getContent());
		System.out.println(intData.getDoubleContent());
		NumberBox<Double> doubleData = new NumberBox<>(175.58);
		System.out.println(doubleData.getContent());
		System.out.println(doubleData.getDoubleContent());
		NumberBox<Float> floatData = new NumberBox<>(15.87f);
		System.out.println(floatData.getContent());
		System.out.println(floatData.getDoubleContent());
	}

}
