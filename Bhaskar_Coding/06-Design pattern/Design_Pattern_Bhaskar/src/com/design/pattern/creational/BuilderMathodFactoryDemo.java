package com.design.pattern.creational;

import java.util.ArrayList;
import java.util.List;

//Product class
class Pizza {
	private String dough;
	private String sauce;
	private List<String> toppings=new ArrayList<>();

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(String data) {
		toppings.add(data);
	}

	@Override
	public String toString() {
		return "Pizza [dough=" + dough + ", sauce=" + sauce + ", toppings=" + toppings + "]";
	}

}

//Builder interface
interface PizzaBuilder {
	void buildDough();

	void buildSauce();

	void buildToppings();

	Pizza getPizza();
}

//concreate Builders
class HawaiiPizza implements PizzaBuilder {

	private Pizza pizza;

	public HawaiiPizza() {
		this.pizza = new Pizza();
	}

	@Override
	public void buildDough() {
		pizza.setDough("Pan Crust");

	}

	@Override
	public void buildSauce() {
		pizza.setSauce("Tomato Sauce");

	}

	@Override
	public void buildToppings() {
	System.out.println("Tst");
	pizza.setToppings("Ham");
	}

	@Override
	public Pizza getPizza() {
		// TODO Auto-generated method stub
		return pizza;
	}

}

//director classes //optional 
class Chef {
	private PizzaBuilder builder;

	public Chef(PizzaBuilder builder) {
		this.builder = builder;
	}

	public Pizza getPizza() {
		return this.builder.getPizza();
	}

	public void constructPizza() {
		builder.buildDough();
		builder.buildSauce();
		builder.buildToppings();
	}

}

public class BuilderMathodFactoryDemo {
	public static void main(String[] args) {

		PizzaBuilder builder = new HawaiiPizza();
		Chef chef = new Chef(builder);
		chef.constructPizza();

		System.out.println(chef.getPizza());
	}
}
