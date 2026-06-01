package com.IO.FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {

	public static void main(String[] args) {
		FileWriter writer=null;
		BufferedWriter bufferWriter=null;
		try {
			writer = new FileWriter("bhaskar.text", false);
			bufferWriter = new BufferedWriter(writer);
			bufferWriter.write("I am writing content to given file using buffered writer \n");
			bufferWriter.write("I am done with writing \n");
			
			bufferWriter.flush();
			
			System.out.println("Successfullt update the file !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bufferWriter !=null) {
				try {
					bufferWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
