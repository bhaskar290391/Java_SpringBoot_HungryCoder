package com.Generics;

import java.util.ArrayList;
import java.util.List;

public class TypeInferenceExample {

	public static void main(String[] args) {
		List<String> data=new ArrayList<>();
		data.add("java");
		data.add("Generic ");
		data.add("Type inference");
		
		System.out.println("The Data is ");
		
		for (String string : data) {
			System.out.println("The object is "+ string);
		}

	}

}
