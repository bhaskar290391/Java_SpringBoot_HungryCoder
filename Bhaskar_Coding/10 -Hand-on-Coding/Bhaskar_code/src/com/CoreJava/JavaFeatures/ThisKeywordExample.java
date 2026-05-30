package com.CoreJava.JavaFeatures;

public class ThisKeywordExample {

	int var1;
	int var2;

	public ThisKeywordExample(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
	public void display() {
		System.out.println("var 1 : "+ this.var1+"  var 2 : "+ this.var2);
	}

	public static void main(String[] args) {
		ThisKeywordExample data = new ThisKeywordExample(20,40);
		data.display();
	}

}
