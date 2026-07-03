package com.java8.video;

import java.util.List;
import java.util.stream.Collectors;

public class Stream_Example_2 {
	public static void main(String[] args) {

		List<Integer> data = List.of(1, 2, 2, 4, 4, 3, 5, 5, 6, 7, 8, 9, 9, 10);

		List<Integer> squareOfEvenNumber = data.stream().filter(number -> number % 2 == 0)
				.map(number -> number * number).distinct().collect(Collectors.toList());
		System.out.println("squareOfEvenNumber ==>" + squareOfEvenNumber);
		
		
		System.out.println( "The count is "+ data.stream().filter(number -> number >5).count() );
		
		System.out.println("The sum is "+data.stream().mapToInt(number -> number).sum());
	}
}
