package com.design.pattern.behaviour;

interface Strategy {
	int execute(int a, int b);
}

class AdditionStrategy implements Strategy {

	@Override
	public int execute(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}

class SubstractionStrategy implements Strategy {

	@Override
	public int execute(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

}

class MultiplicationStrategy implements Strategy {

	@Override
	public int execute(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

}

class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int a, int b) {
		return strategy.execute(a, b);
	}
}

public class StrategyDesignPattern {

	public static void main(String[] args) {

		Context context = new Context();

		context.setStrategy(new AdditionStrategy());
		System.out.println(context.executeStrategy(10, 5));

		context.setStrategy(new MultiplicationStrategy());
		System.out.println(context.executeStrategy(10, 5));

		context.setStrategy(new SubstractionStrategy());
		System.out.println(context.executeStrategy(10, 5));
	}

}
