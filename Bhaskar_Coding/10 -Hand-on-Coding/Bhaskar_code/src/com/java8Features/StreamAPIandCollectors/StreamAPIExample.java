package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		// Output: Filtered List: [abc, bc, efg, abcd, jkl]
		// Output: Lengths of non-empty strings: [3, 2, 3, 4, 3]
		
		List<String> filteredList = strings.stream().filter(string-> !string.isEmpty()).collect(Collectors.toList());
		List<Integer> lengthList=strings.stream().filter(string-> !string.isEmpty()).map(String::length).collect(Collectors.toList());
		
		System.out.println("Filtered List: "+ filteredList);
		System.out.println("Lengths of non-empty strings: "+ lengthList);
	}
}
