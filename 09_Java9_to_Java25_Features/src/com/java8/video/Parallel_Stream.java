package com.java8.video;

import java.util.Arrays;

public class Parallel_Stream {
	public static void main(String[] args) {

		int number[] = new int[100000];
		Arrays.fill(number, 2);

		long start = System.currentTimeMillis();
		int sequentialSum = Arrays.stream(number).sum();
		System.out.println("sequential " + sequentialSum);
		long end = System.currentTimeMillis();

		System.out.println("Total time " + (end - start));

		long startParallel = System.currentTimeMillis();
		int parallelSum = Arrays.stream(number).sum();
		System.out.println("parallelSum " + parallelSum);
		long endParellel = System.currentTimeMillis();

		System.out.println("Total time " + (endParellel - startParallel));
	}
}
