package com.design.pattern.SRP;

public class ProductAfterSRP {

	private String name;
	private Integer price;

	public ProductAfterSRP(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}

class ProductRepository {
	public void saveProduct(ProductAfterSRP product) {
		// database logic

		System.out.println("Saving product into DAtabase");
	}
}

class ProductInvoicegenerator {
	public void generateInvoice(ProductAfterSRP product) {
		// Generating invoice

		System.out.println("Generating the invoice !!!" + product.getName());
	}

}
