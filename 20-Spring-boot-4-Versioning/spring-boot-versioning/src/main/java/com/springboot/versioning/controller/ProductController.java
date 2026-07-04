package com.springboot.versioning.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.versioning.dto.ProductResponseV1;
import com.springboot.versioning.dto.ProductResponseV2;
import com.springboot.versioning.dto.ProductResponseV2.ProductV2;
import com.springboot.versioning.entity.Product;
import com.springboot.versioning.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@GetMapping(version = "1")
	public List<ProductResponseV1> getProductList() {
		try {
			return service.getProductList().stream().map(this::getResponseV1Product).collect(Collectors.toList());
		} catch (RuntimeException e) {
			return fallbackMethod(e);
		}

	}

	private List<ProductResponseV1> fallbackMethod(RuntimeException e) {
		System.out.println("The fallback method");
		return Collections.emptyList();
	}

	@GetMapping(version = "2")
	public ProductResponseV2 getProductListV2() {
		return this.getResponseV2Product(service.getProductList());
	}

	private ProductResponseV1 getResponseV1Product(Product theProduct) {
		return new ProductResponseV1(theProduct.id(), theProduct.name(), theProduct.price());
	}

	private ProductResponseV2 getResponseV2Product(List<Product> theProduct) {

		Stream<ProductV2> data = theProduct.stream().map(product -> new ProductResponseV2.ProductV2(product.id(),
				product.name(), product.price(), product.description(), product.category()));
		return new ProductResponseV2(data.collect(Collectors.toList()), theProduct.size());
	}
}
