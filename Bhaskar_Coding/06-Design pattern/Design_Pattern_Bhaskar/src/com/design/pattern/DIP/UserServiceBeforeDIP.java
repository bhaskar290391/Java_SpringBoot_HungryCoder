package com.design.pattern.DIP;

class MySQLDatabase {
	public void connect() {
		System.out.println("MySql database used to connect");
	}

	public void SaveUser(String userName) {
		System.out.println("Saving the users " + userName);
	}
}

public class UserServiceBeforeDIP {
	MySQLDatabase mysqlDataBase;

	public UserServiceBeforeDIP() {
		this.mysqlDataBase = new MySQLDatabase();
	}

	public void addUser(String user) {
		mysqlDataBase.connect();
		mysqlDataBase.SaveUser(user);
	}

	public static void main(String[] args) {
		UserServiceBeforeDIP data=new UserServiceBeforeDIP();
		data.addUser("bhaskar");
	}
}
