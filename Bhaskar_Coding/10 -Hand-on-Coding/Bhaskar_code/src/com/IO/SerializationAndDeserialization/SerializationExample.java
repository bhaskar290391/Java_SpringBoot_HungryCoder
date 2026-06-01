package com.IO.SerializationAndDeserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class SerializationExample {

	public static void main(String[] args) {

		Student student = new Student("bhaskar", 29);

		FileOutputStream output;
		try {
			output = new FileOutputStream("bhakar.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(output);

			objectOut.writeObject(student);
			objectOut.close();
			System.out.println("File is serialized ");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
