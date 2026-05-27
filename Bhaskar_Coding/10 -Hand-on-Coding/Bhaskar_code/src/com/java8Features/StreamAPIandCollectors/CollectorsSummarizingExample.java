package com.java8Features.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsSummarizingExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 8, 1, 9, 12, 4);
		
		// Output: Summary Statistics: IntSummaryStatistics{count=7, sum=42, min=1, average=6.000000, max=12}
		
		IntSummaryStatistics data=numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(" Summary Statistics "+data);
	}

}
