package com.CoreJava.ArchitecturalPatterns;

public class UserController {

	private UserDetail model;
	private Userview view;

	public UserController(UserDetail model, Userview view) {
		this.model = model;
		this.view = view;
	}

	public void updateViewStatus() {
		view.displayUserStatus(model.getName(), model.getEmail());
	}

}
