package com.IO.FileHandling;

import java.io.File;
import java.io.IOException;

public class FileHandlingExample {
	public static void main(String[] args) throws IOException {

		File file =new File("Kanishk.txt");
		
		if(file.exists()) {
			System.out.println("File already exists");
		}else {
			if(file.createNewFile()) {
				System.out.println("File created :"+file.getName());
			}else {
				System.out.println("File creation Failed !!!");
			}
		}
		
		System.out.println("File name :"+file.getName());
		System.out.println("Absolute Path :"+file.getAbsolutePath());
		System.out.println("Write : "+ file.canWrite());
		System.out.println("Reader :"+ file.canRead());
		System.out.println("File size "+file.length());
	}
}
