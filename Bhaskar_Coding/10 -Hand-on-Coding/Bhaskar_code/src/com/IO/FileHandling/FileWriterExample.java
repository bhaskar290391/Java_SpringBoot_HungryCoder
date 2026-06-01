package com.IO.FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) {
		
		FileWriter writer;
		try {
			writer = new FileWriter("example.txt");
			writer.write("Author : Bhaskar");
			
			writer.flush();
			
			writer.close();
			System.out.println("Successfully file write has been done !!!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
