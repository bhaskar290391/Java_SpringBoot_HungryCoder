package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningByExample {

	public static void main(String[] args) {
		
		  List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		  
		  // Output: Partitioned by Empty: {false=[abc, bc, efg, abcd, jkl], true=[, ]}
		  
		  Map<Boolean, List<String>> collect = strings.stream().collect(Collectors.partitioningBy(data-> data.isEmpty()));
		  
		  System.out.println(collect);

	}

}
