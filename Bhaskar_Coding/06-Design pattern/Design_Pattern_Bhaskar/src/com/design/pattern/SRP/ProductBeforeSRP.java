package com.design.pattern.SRP;

public class ProductBeforeSRP {

	private String name;
	private Integer price;
	
	
	public ProductBeforeSRP(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void saveProduct() {
		//database logic 
		
		System.out.println("Saving product into DAtabase");
	}
	
	public void generateInvoice() {
		//Generating invoice
		
		System.out.println("Generating the invoice !!!");
	}
	
	
}
