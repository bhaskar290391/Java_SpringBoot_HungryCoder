package com.design.pattern.OCP;

interface Notification{
	public void notifyData();
}

class Email implements Notification{
	@Override
	public void notifyData() {
		System.out.println("Email Notification");		
	}
}


class Call implements Notification{
	@Override
	public void notifyData() {
		System.out.println("Call Notification");		
	}
}


class SMS implements Notification{
	@Override
	public void notifyData() {
		System.out.println("SMS Notification");		
	}
}


class OTP implements Notification{
	@Override
	public void notifyData() {
		System.out.println("OTP Notification");		
	}
}
public class NotificationServiceAfterOCP {

	public void notification(Notification notification) {
		notification.notifyData();
	}

}
