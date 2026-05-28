package com.Collections.Sets;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {

		HashSet<String> data = new HashSet<>();
		data.add("USA");
		data.add("MEXICO");
		data.add("CANADA");

		System.out.println("The data is " + data);

		if (data.contains("CANADA")) {
			System.out.println("The canada is present in the set");
		}

		for (String string : data) {
			System.out.println("The data inside the set ==> " + string);
		}

		data.remove("MEXICO");
		System.out.println("data ==>" + data);
	}

}
