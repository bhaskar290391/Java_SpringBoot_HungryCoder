package com.design.pattern.LSP;

public abstract class BirdAfterLSP {

	public abstract void eat();
}

interface Flyable {
	public void fly();
}

interface Swimmable {
	public void swim();
}

class Sparrow extends BirdAfterLSP implements Flyable {

	@Override
	public void fly() {
		System.out.println("Sparrow is flying");
	}

	@Override
	public void eat() {
		System.out.println("Sparrow is eating");
	}

}

class Penguins extends BirdAfterLSP implements Swimmable {

	@Override
	public void eat() {
		System.out.println("Sparrow is eating");
	}

	@Override
	public void swim() {
		System.out.println("Penguin is animal ");

	}

}

class BirdWatcherData {

	public void watchBirdFly(Flyable bird) {
		bird.fly();
		;
	}

	public void watchBirdSwimmable(Swimmable bird) {
		bird.swim();
	}

	public static void main(String[] args) {

		BirdWatcherData match = new BirdWatcherData();

		Sparrow bird = new Sparrow();
		Penguins penguin = new Penguins();

		match.watchBirdFly(bird);
		match.watchBirdSwimmable(penguin);
	}
}
