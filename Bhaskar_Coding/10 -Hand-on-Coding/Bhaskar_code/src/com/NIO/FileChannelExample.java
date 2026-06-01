package com.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {

	public static void main(String[] args) throws IOException {

		try {
			RandomAccessFile file = new RandomAccessFile("example.txt", "rw");
			
			FileChannel channel = file.getChannel();
			
			ByteBuffer br=ByteBuffer.allocate(1024);
			br.put("Hello Bhaskar".getBytes());
			br.flip();
			
			while (br.hasRemaining()) {
				channel.write(br);
			}
			
			channel.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
