package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsCountingExample {

	public static void main(String[] args) {
		  List<String> data = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		 long count= data.stream().filter(string -> !string.isEmpty()).collect(Collectors.counting());
		  System.out.println("The counting of straing data is ==> "+ count);
	}
}
