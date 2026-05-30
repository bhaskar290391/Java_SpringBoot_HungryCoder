package com.CoreJava.JavaFeatures;

public class StringMethodsExample {
	public static void main(String[] args) {
		
		String data= "Bhaskar Mudaliyar";
		
		System.out.println("Uppercase "+ data.toUpperCase());
		
		System.out.println("Lowercase "+ data.toLowerCase());
		
		System.out.println("Containes ==> "+ data.contains("Mud"));
		
		System.out.println("replace ==>"+ data.replace("a", "aa"));
		
		for (String string : data.split(" ")) {
			System.out.println("The splited data "+ string);
		}
	}
}
