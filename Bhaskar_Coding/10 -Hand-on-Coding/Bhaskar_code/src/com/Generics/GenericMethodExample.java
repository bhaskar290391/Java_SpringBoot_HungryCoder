package com.Generics;

public class GenericMethodExample {

	public static void main(String[] args) {

		Integer[] intData = { 1, 2, 3, 4, 5 };
		System.out.println("Integer Arrays ==>");
		printArrays(intData);

		String[] strings = { "a", "b", "c", "d", "e" };
		System.out.println("String arrays");
		printArrays(strings);

	}

	private static <T> void printArrays(T[] data) {

		for (T element : data) {
			System.out.print(element+" ");
		}
		System.out.println("");

	}

}
