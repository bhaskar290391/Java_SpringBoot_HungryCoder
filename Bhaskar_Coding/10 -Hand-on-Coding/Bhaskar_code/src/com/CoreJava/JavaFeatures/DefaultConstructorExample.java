package com.CoreJava.JavaFeatures;

public class DefaultConstructorExample {
	int var1;
	int var2;

	public DefaultConstructorExample() {
		this.var1 = 0;
		this.var2 = 0;
	}

	public void display() {
		System.out.println("Var1 :" + var1 + " : var2 :" + var2);
	}

	public static void main(String[] args) {
		DefaultConstructorExample obj = new DefaultConstructorExample();
		obj.display();

	}

}
