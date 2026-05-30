package com.CoreJava.Oops;

abstract class ATM {
	abstract void moneyWithdrawn();

	abstract void checkBalance();
}

class MyATM extends ATM {

	@Override
	void moneyWithdrawn() {

		System.out.println("Money Withdrawn !!!");
	}

	@Override
	void checkBalance() {

		System.out.println("Balance Check !!!");
	}

}

public class AbstractionExample {

	public static void main(String[] args) {

		ATM atm = new MyATM();
		atm.checkBalance();
		atm.moneyWithdrawn();
	}

}
