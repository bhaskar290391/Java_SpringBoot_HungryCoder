package com.java8.video;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Grouby_Example {
	public static void main(String[] args) {

		/*
		 * List<String> immutableList = Stream.of("red","green",null).toList();
		 * immutableList.add("bhaskar");
		 */

		List<String> modifiableList = Stream.of("red", "green", null).collect(Collectors.toList());
		modifiableList.add("bhaskar");
		modifiableList.set(2, "yellow");
		System.out.println(modifiableList);

		record Product(String name, String category, int price) {
		}
		;

		// Define a Supplier for the products stream to create a new stream on each use
		Supplier<Stream<Product>> productsSupplier = () -> Stream.of(new Product("Laptop", "Electronics", 1000),
				new Product("TV", "Electronics", 1500), new Product("Sofa", "Furniture", 700),
				new Product("Table", "Furniture", 300), new Product("Lamp", "Home Decor", 50));

		// grouping by category
		Map<String, List<Product>> groupingByCategory = productsSupplier.get()
				.collect(Collectors.groupingBy(Product::category));
		System.out.println(groupingByCategory);

		// totalprice of product
		Map<String, Integer> groupingByCategoryByRotalSum = productsSupplier.get()
				.collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
		System.out.println(groupingByCategoryByRotalSum);

		// Aggregation: Calculating average price by category

		Map<String, Double> groupingByCategoryByAverge = productsSupplier.get()
				.collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));
		System.out.println(groupingByCategoryByAverge);

		// Aggregation: Counting products by category
		Map<String, Long> groupingByCategoryByCount = productsSupplier.get()
				.collect(Collectors.groupingBy(Product::category, Collectors.counting()));
		System.out.println(groupingByCategoryByCount);

		// Filtering: Products with price greater than 1499
		System.out.println(productsSupplier.get().filter(product -> product.price > 1499).collect(Collectors.toList()));

		// Mapping: Extracting product categories
		System.out.println(productsSupplier.get().map(Product::category).collect(Collectors.toList()));

		// Partitioning: Separate products into expensive and cheap
		System.out.println(productsSupplier.get().collect(Collectors.partitioningBy(product -> product.price > 1000)));

		// // Using SummaryStatistics for product prices by category
		System.out.println(productsSupplier.get()
				.collect(Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price))));
	}
}
