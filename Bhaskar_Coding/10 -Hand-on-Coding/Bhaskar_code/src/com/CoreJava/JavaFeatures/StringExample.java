package com.CoreJava.JavaFeatures;

public class StringExample {

	public static void main(String[] args) {

		String str1 = "Bhaskar";
		String str2 = "Mudaliyar";

		String str3 = str1 + " " + str2;
		System.out.println("Concating two string" + str3);

		System.out.println("Lenghth of string str3 --> " + str3.length());

		System.out.println("Charcter at specific index 1 " + str3.charAt(2));

		System.out.println("substring of charcater ==> " + str3.substring(6, 11));

	}

}
