package com.CoreJava.JavaFeatures;

public class StringBufferExample {

	public static void main(String[] args) {

		StringBuffer bf = new StringBuffer("Hello");

		bf.append("  World ");
		System.out.println("The appended string is " + bf);

		bf.insert(6, "beautiful");
		System.out.println("Inserted String ==> " + bf);

		bf.replace(6, 15, "amazing");
		System.out.println("The replaced charater ==> " + bf);

		bf.delete(6, 14);
		System.out.println("Deleted string ==> " + bf);

		bf.reverse();
		System.out.println("Reversed String ==> " + bf);
	}

}
