package com.design.pattern.DIP;

interface Database {
	public void connect();

	public void saveUser(String userName);
}

class MySQLDatabases implements Database {
	public void connect() {
		System.out.println("MySql database used to connect");
	}

	public void saveUser(String userName) {
		System.out.println("Saving the users " + userName);
	}
}

class OracleDatabase implements Database {
	public void connect() {
		System.out.println("Oracle database used to connect");
	}

	public void saveUser(String userName) {
		System.out.println("Oracle Saving the users " + userName);
	}
}

public class UserServiceAfterDIP {
	private Database database;

	public UserServiceAfterDIP(Database database) {
		super();
		this.database = database;
	}

	public void addUser(String User) {
		database.connect();
		database.saveUser(User);
	}

	public static void main(String[] args) {
		UserServiceAfterDIP data = new UserServiceAfterDIP(new MySQLDatabases());
		data.addUser("Bhaskar");
	}

}
