package com.Generics;

class Pair<T, U> {
	private T first;
	private U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public U getSecond() {
		return second;
	}

	public void setSecond(U second) {
		this.second = second;
	}

}

public class GenericClassExample {

	public static void main(String[] args) {

		Pair<Integer, String> pair1 = new Pair<>(29, "Bhaskar");
		System.out.println(pair1.getFirst() + " ==> " + pair1.getSecond());
		
		
		Pair<String, Double> pair2 = new Pair<>("PI", 3.14);
		System.out.println(pair2.getFirst() + " ==> " + pair2.getSecond());
	}

}
