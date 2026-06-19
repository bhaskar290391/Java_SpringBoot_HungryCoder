package com.design.pattern.OCP;

public class NotificationBeforeOCP {

	public void notification(String type) {

		if (type.equals("Email")) {
			System.out.println("Email notification");

		} else if (type.equals("OTP")) {

			System.out.println("OTP Notidication");

		} else if (type.equals("SMS")) {

			System.out.println("SMS notification");

		} else if (type.equals("Call OTP")) {

			System.out.println("Call notification");
		}
	}

}
