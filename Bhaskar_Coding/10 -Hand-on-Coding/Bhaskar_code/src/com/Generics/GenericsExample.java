package com.Generics;

class Box<T> {
	private T content;

	public Box(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}

public class GenericsExample {

	public static void main(String[] args) {

		Box<Integer> intBox = new Box<>(29);
		System.out.println(intBox.getContent());

		Box<String> stringBox = new Box<>("bhaskar");
		System.out.println(stringBox.getContent());
	}

}
