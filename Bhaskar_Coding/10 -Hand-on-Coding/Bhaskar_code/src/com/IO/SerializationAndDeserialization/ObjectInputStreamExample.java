package com.IO.SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamExample {
	public static void main(String[] args) {

		 try {
	            // Create a FileInputStream to read objects from the file "student.ser"
	            FileInputStream fileIn = new FileInputStream("names.ser");

	            // Create an ObjectInputStream to read objects from the FileInputStream
	            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

	            // Read the object from the ObjectInputStream and cast it to Student class
	            List<String> data = (List<String>) objectIn.readObject();

	            // Close the ObjectInputStream
	            objectIn.close();

	          for (String string : data) {
				System.out.println("String ==>"+ string);
			}

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
}
