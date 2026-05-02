package com.example.jpa.jpa_demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.jpa_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByLastName(String lastName);

	@Query("select u from User u where u.email=?1")
	public User findByEmailAdrress(String email);
	
	@Query(value = "select * from user_management_table u where u.email=:email",nativeQuery = true)
	public User findByEmailAdrressByNative(String email);

}
