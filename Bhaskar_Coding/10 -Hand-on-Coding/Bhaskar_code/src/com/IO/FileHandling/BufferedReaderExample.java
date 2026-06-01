package com.IO.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {

		try {
			FileReader fileReader = new FileReader("example.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);

			while (bufferReader.readLine() != null) {
				System.out.println(bufferReader.readLine());
			}

			bufferReader.close();
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
