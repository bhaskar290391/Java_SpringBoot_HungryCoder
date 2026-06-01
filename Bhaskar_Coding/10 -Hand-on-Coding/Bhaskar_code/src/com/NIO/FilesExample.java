package com.NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {

	public static void main(String[] args) {

		Path path = Paths.get("example.txt");
		try {
			List<String> data = Files.readAllLines(path);
			for (String line : data) {
				System.out.println("The line ==> " + line);
			}

			
			Path newFile=Paths.get("newFile.txt");
			Files.write(newFile,data);
			
			System.err.println("File operation successfuly");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
