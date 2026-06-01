package com.IO.SerializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {

	public static void main(String[] args) {

		List<String> data = new ArrayList<>();
		data.add("bhaskar");
		data.add("Maddy");
		data.add("Kanishk");

		System.out.println("The list is " + data);

		try {
			FileOutputStream output = new FileOutputStream("names.ser");
			ObjectOutputStream opt = new ObjectOutputStream(output);

			opt.writeObject(data);
			opt.close();
			
			System.out.println("Names is succesfullu serialized");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
