package com.CoreJava.JavaFeatures;

public class ConstructorExample {

	int var1;
	int var2;

	public ConstructorExample() {
		var1 = 0;
		var2 = 0;
		System.out.println("Default constructor is called !!!");
	}

	public ConstructorExample(int var1, int var2) {

		this.var1 = var1;
		this.var2 = var2;
		System.out.println("Parametrized Constructor is called !!!");
	}

	public void display() {
		System.out.println("Var1 :" + var1 + " : var2 :" + var2);
	}

	public static void main(String[] args) {

		ConstructorExample defaultConstructor = new ConstructorExample();
		defaultConstructor.display();

		ConstructorExample para = new ConstructorExample(29, 31);
		para.display();
	}

}
