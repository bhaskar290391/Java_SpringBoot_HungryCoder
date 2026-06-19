package com.design.pattern.creational;

//product interface 
interface FactoryClientDemo {

	void open();

	void save();

	void close();
}

//Concrete Product class 
class TextDocument implements FactoryClientDemo {

	@Override
	public void open() {
		System.out.println("Text document is opening");
	}

	@Override
	public void save() {
		System.out.println("Text document is saving");
	}

	@Override
	public void close() {
		System.out.println("Text document is closing");

	}

}

class SpreadSheetDocument implements FactoryClientDemo {

	@Override
	public void open() {
		System.out.println("SpreadSheet document is opening");
	}

	@Override
	public void save() {
		System.out.println("SpreadSheet document is saving");
	}

	@Override
	public void close() {
		System.out.println("SpreadSheet document is closing");

	}

}

//Createor class
abstract class Application {

	abstract FactoryClientDemo createDocument();
}

//concreate creator class
class TextApplication extends Application {

	@Override
	FactoryClientDemo createDocument() {
		// TODO Auto-generated method stub
		return new TextDocument();
	}

}

class SpreadSheetApplication extends Application {

	@Override
	FactoryClientDemo createDocument() {
		// TODO Auto-generated method stub
		return new SpreadSheetDocument();
	}

}

public class FactoryClientDemos {
	public static void main(String[] args) {
		Application app;

		String type = "text";

		if (type.equals("text")) {
			app = new TextApplication();
		} else {
			app = new SpreadSheetApplication();
		}

		FactoryClientDemo data = app.createDocument();
		data.open();
	}
}
