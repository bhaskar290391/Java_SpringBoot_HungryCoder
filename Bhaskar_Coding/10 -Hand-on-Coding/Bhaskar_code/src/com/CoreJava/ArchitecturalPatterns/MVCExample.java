package com.CoreJava.ArchitecturalPatterns;

public class MVCExample {

	public static void main(String[] args) {

		UserDetail model = new UserDetail("bhaskar", "maddy@gmail.com");

		Userview view = new Userview();

		UserController controller = new UserController(model, view);

		controller.updateViewStatus();
	}

}
