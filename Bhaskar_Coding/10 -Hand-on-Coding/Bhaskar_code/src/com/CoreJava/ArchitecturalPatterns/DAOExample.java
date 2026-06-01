package com.CoreJava.ArchitecturalPatterns;

import java.util.List;

//Dao Example pattern 
class User {
	private int id;
	private String name;
	private String email;

	public User(int id, String name, String email) {

		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}

interface UserDao {

	void insert(User user);

	void update(User user);

	void delete(User user);

	User getUserById(int id);

	List<User> allUser();
}

class UserImpl implements UserDao {

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return null;
	}

}

public class DAOExample {
	public static void main(String[] args) {

		UserDao userDao = new UserImpl();

		User user = new User(29, "bhaskar", "maddy@gmail.com");
		userDao.insert(user);

		User userData = userDao.getUserById(29);
	}
}
