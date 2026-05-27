package com.java8FeaturesOptionalClass;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Example {
	public static void main(String[] args) {
		
		String helloWorld ="Hello world";
		String encode= encodeBase64(helloWorld);
		
		String decode=decodeBase64(encode);
		
		System.out.println("The encode character "+ encode);
		System.out.println("The decode character "+ decode);

	}

	private static String decodeBase64(String encode) {
		Decoder decoder = Base64.getDecoder();
		
		byte[] decode = decoder.decode(encode);
		return new String(decode);
	}

	private static String encodeBase64(String helloWorld) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(helloWorld.getBytes());
	}
}
