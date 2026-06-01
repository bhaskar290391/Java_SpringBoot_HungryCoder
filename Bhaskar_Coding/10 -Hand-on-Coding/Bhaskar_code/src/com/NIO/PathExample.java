package com.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	public static void main(String[] args) {
		
		Path path=Paths.get("/Java_Handon_Coding/example.txt");
		
		System.out.println("File name :"+path.getFileName());
		System.out.println("parent directory :"+ path.getParent());
		
		System.out.println("Root Component :" + path.getRoot());
		
		System.out.println("Number of name element in the path "+path.getNameCount());
		
		//path to absolute path 
		System.out.println("Absolute path :"+ path.toAbsolutePath());

	}

}
