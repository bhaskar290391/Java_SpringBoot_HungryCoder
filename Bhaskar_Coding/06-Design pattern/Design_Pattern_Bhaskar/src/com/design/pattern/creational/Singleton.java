package com.design.pattern.creational;

public class Singleton {
	// eager initialization
	// private static final Singleton instance = new Singleton();

	private static Singleton instance;

	private Singleton() {

	}

	/**
	 
	public static Singleton getInstance() {

		//lazy approach
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	*/
	
	//synchronized
	public static synchronized  Singleton getInstance() {

		//lazy approach
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
