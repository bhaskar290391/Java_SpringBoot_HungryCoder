package com.java8.video;

import java.util.List;

class Transaction {
	private String category;
	private double amount;

	public Transaction() {

	}

	public Transaction(String category, double amount) {
		super();
		this.category = category;
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [category=" + category + ", amount=" + amount + "]";
	}

}

public class Stream_Example_1 {
	public static void main(String[] args) {

		List<Transaction> data = List.of(new Transaction("Groceries", 2500), new Transaction("Groceries", 1500),
				new Transaction("Entertainment", 500), new Transaction("utilities", 1200),
				new Transaction("Entertainment", 800), new Transaction("utilities", 780));

		double groceriesAmount = data.stream().filter(trans -> trans.getCategory().equals("Groceries"))
				.mapToDouble(Transaction::getAmount).sum();

		System.out.println("groceriesAmount " + groceriesAmount);
		
		double transactionAmount = data.stream()
				.mapToDouble(Transaction::getAmount).sum();

		System.out.println("transactionAmount " + transactionAmount);
	}
}
