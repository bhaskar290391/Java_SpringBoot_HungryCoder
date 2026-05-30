package com.CoreJava.Oops;

class InnerClass {

	private String outer = "Outer Field";

	class Inner {
		public void display() {
			System.out.println("Inner class accessing out field " + outer);
		}
	}

	static class InnerStaticClass {
		public void display() {
			System.out.println("Inner static class");
		}
	}
}

public class InnerClassExample {
	public static void main(String[] args) {

		InnerClass outer = new InnerClass();

		InnerClass.Inner inner = outer.new Inner();
		inner.display();

		InnerClass.InnerStaticClass data = new InnerClass.InnerStaticClass();
		data.display();
	}
}
