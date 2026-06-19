package com.design.pattern.LSP;

public class BirdBeforeLSP {

	public void birdFly() {
		System.out.println("Bird fly!!");
	}
}

class Penguin extends BirdBeforeLSP {
	@Override
	public void birdFly() {
		throw new UnsupportedOperationException("Penguin Cant fly !!");
	}
}

class BirdWatcher {

	public void watchBirdFly(BirdBeforeLSP bird) {
		bird.birdFly();
	}

	public static void main(String[] args) {

		BirdWatcher match = new BirdWatcher();

		BirdBeforeLSP bird = new BirdBeforeLSP();
		Penguin penguin = new Penguin();

		match.watchBirdFly(bird);
		match.watchBirdFly(penguin);
	}
}
