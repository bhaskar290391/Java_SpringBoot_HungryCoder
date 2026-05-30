package com.CoreJava.JavaFeatures;

public class StaticKeywordExample {

	
	int  instanceVar;
	static int staticVar = 10;

	public static void staticMethod() {
		System.out.println("Inside the static method ");
	}
	
	

	public StaticKeywordExample(int instanceVar) {
		this.instanceVar = instanceVar;
	}



	public static void main(String[] args) {
		System.out.println(StaticKeywordExample.staticVar);
		StaticKeywordExample.staticMethod();

		
		StaticKeywordExample data=new StaticKeywordExample(25);
		System.out.println(data.instanceVar);
	}

}
