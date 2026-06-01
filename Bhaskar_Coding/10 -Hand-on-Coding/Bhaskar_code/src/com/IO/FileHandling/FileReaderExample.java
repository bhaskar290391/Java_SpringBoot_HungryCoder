package com.IO.FileHandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

	public static void main(String[] args) throws IOException {

		try {
			// Create a FileReader object to read from a file
			FileReader reader1 = new FileReader("example.txt");
			int character;

			// Read and print characters from the file
			while ((character = reader1.read()) != -1) {
				System.out.print((char) character);
			}

			// Close the FileReader
			reader1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
