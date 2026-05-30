package com.CoreJava.JavaFeatures;

public class CopyConstructorExample {
	int var1;
	int var2;

	public CopyConstructorExample(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}

	public CopyConstructorExample(CopyConstructorExample example) {
		this.var1 = example.var1;
		this.var2 = example.var2;
	}

	public void display() {
		System.out.println("Var1 :" + var1 + " : var2 :" + var2);
	}

	public static void main(String[] args) {

		CopyConstructorExample original = new CopyConstructorExample(20, 40);
		original.display();

		CopyConstructorExample copy = new CopyConstructorExample(original);
		copy.display();

	}

}
