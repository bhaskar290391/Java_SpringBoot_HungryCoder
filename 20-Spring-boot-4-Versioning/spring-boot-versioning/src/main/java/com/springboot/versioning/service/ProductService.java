package com.springboot.versioning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.springboot.versioning.entity.Product;

@Service
public class ProductService {

	private final List<Product> theProduct;
	private static AtomicInteger count = new AtomicInteger(0);
	private static AtomicInteger attempCounter = new AtomicInteger(0);

	public ProductService() {
		theProduct = new ArrayList<>();

		theProduct.add(new Product(1, "Iphone", 599.9, "Mobile Phone", "SmartPhone"));
		theProduct.add(new Product(2, "Samsung", 499.9, "Mobile Phone", "SmartPhone"));
		theProduct.add(new Product(3, "Airpod", 399.9, "Accessories", "Accessories"));
	}

	//for /L %i in (1,1,3) do start /b curl -s -X GET http://localhost:8080/api/products : for concurrency limit checking
	@Retryable(maxRetries = 4, delay = 1000, maxDelay = 6000, jitter = 10, multiplier = 3)
	@ConcurrencyLimit(2)
	public List<Product> getProductList() {
		
		//For Concurrency Limit
		/*
		 		int counter = count.incrementAndGet();
				System.out.println("Started -active " + counter);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		count.decrementAndGet();
		System.out.println("done " + (counter - 1));
		 */

		
		/*
		 * For Retryable 
		 */
		int attempt= attempCounter.incrementAndGet();
		System.out.println("The attempt is "+ attempt);
		if(attempt <=10) {
			System.out.println("The failed Attempt is "+ attempt);
			throw new RuntimeException("Retryable  issue");
		}
		
		System.out.println("The successfull attempt is "+ attempt);
		attempCounter.set(0);
		return new ArrayList<>(theProduct);
	}
}
