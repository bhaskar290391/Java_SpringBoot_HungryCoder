package com.java8Features.OptionalClass;

import java.util.Optional;

public class OptionalClassExample {

	public static void main(String[] args) {
		OptionalClassExample example = new OptionalClassExample();

		Optional<String> data = Optional.of("Hello World");
		System.out.println("Non-Empty Optional: " + data);
		System.out.println("Value: " + data.get());
		
		System.out.println("");
		Optional<String> nullableData=Optional.ofNullable(example.getNullableValue());
		System.out.println("nullableData " + nullableData);
		nullableData.ifPresent(value -> System.out.println(value));
		
		System.out.println();
		//create optional of empty
		Optional<String> datas=Optional.empty();
		System.out.println("Optional empty ==>"+ datas);
		
		String defaultValueOfNullable = nullableData.orElse("Default Value for nullable ");
		System.out.println(" defaultValueOfNullable ==> "+ defaultValueOfNullable);
		
		System.out.println();
		
		defaultValueOfNullable=datas.orElseGet(()-> "Default value for supplier");
		System.out.println("defaultValueOfNullable for supplier ==> "+ defaultValueOfNullable);
		
		
		try {
			data.orElseThrow(()->new IllegalArgumentException("Value is not present"));
		}catch (Exception e) {
			System.out.println("Exception ==> "+ e.getMessage());
		}
	}
	
	  // Method that returns a potentially null value
    public String getNullableValue() {
        // Return null for demonstration purposes
        return null;
    }

}
