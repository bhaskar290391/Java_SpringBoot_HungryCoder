package com.NIO;

import java.nio.IntBuffer;

public class BufferExample {

	public static void main(String[] args) {
		IntBuffer data=IntBuffer.allocate(5);

		for (int i = 1; i <= data.capacity(); i++) {
			data.put(i*2);
		}
		
		data.flip();
		
		while (data.hasRemaining()) {
			System.out.println(data.get());
		}
	}

}
