package com.example.jpa.jpa_demo.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.jpa_demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class UserService {

	private UserRepository repository;

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void createUser(User user) {
		manager.persist(user);
	}

	public User findById(long id) {
		return manager.find(User.class, id);
	}

	@Transactional
	public void deleteByUser(User user) {
		manager.remove(user);

	}

	@Transactional
	public User updateUser(User user) {
		return manager.merge(user);
	}

	public List<User> findAllUsers() {
		Query query = manager.createQuery("select u from User u");
		return query.getResultList();
	}

	public List<User> findAllUsersByNative() {
		Query query = manager.createNativeQuery("select * from user_management_table u", User.class);
		return query.getResultList();
	}

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findUserByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

	public User findByEmailAddress(String email) {
		return repository.findByEmailAdrress(email);
	}

	public User findByEmailAddressByNative(String email) {
		return repository.findByEmailAdrressByNative(email);
	}
}
