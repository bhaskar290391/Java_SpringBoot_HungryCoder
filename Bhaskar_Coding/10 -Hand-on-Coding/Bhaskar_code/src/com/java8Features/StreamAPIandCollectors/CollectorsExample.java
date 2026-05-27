package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExample {

	public static void main(String[] args) {
		  List<String> data = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		  
		  List<String> filteredString = data.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		  
		  System.out.println("The filtered list of String is "+ filteredString);
		  
		  String mergedString = data.stream().filter(string -> !string.isEmpty()).collect( Collectors.joining(","));
		  
		  System.out.println(mergedString);

	}

}
