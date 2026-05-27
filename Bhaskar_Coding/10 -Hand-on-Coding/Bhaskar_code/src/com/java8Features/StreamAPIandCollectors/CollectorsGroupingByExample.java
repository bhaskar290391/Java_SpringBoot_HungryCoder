package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupingByExample {

	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("abc", "ab", "bc", "efg", "abcd", "jkl");
		  // Output: Grouped by Length: {2=[ab, bc], 3=[abc, efg, jkl], 4=[abcd]}
		 
		 Map<Integer, List<String>> collect = strings.stream().collect(Collectors.groupingBy(String::length));
		 System.out.println(collect);
	}

}
