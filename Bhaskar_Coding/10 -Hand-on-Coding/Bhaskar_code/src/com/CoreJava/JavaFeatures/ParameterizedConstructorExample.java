package com.CoreJava.JavaFeatures;

public class ParameterizedConstructorExample {

	int var1;
	int var2;

	public ParameterizedConstructorExample(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
		System.out.println("Parameterized Constructor is called");
	}
	
	public void display() {
		System.out.println("Var1 :" + var1 + " : var2 :" + var2);
	}

	public static void main(String[] args) {
		ParameterizedConstructorExample para=new ParameterizedConstructorExample(20, 30);
		para.display();
	}
}
