package com.CoreJava.JavaFeatures;

public class WrapperClassExample {

	public static void main(String[] args) {

		int intValue = 100;
		Integer data = intValue;
		System.out.println("Integer value ==> " + data);

		Integer data1 = new Integer(1000);
		int intData = data1;
		System.out.println("Unboxing ==>" + intData);

		String str = "123";
		int data4 = Integer.parseInt(str);
		System.out.println(data4);

		System.out.println("Integer max value " + Integer.MAX_VALUE);
		System.out.println("Double min value " + Double.MIN_VALUE);
	}

}
