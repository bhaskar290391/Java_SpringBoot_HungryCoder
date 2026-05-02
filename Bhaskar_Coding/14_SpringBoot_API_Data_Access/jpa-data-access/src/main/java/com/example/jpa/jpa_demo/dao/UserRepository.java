package com.example.jpa.jpa_demo.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa.jpa_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByLastName(String lastName);

	@Query("select u from User u where u.email=?1")
	public User findByEmailAdrress(String email);

	@Query(value = "select * from user_management_table u where u.email=:email", nativeQuery = true)
	public User findByEmailAdrressByNative(String email);

	@Query("select u from User u where u.firstName like %:firstName% ")
	public List<User> findFirstNameContaining(@Param("firstName") String firstName, Sort sort);

	@Query(value = "select * from user_management_table u where u.first_name like :firstName", nativeQuery = true)
	public List<User> findFirstNameContainingNative(@Param("firstName") String firstName, Pageable page);
	
	
	@Modifying
	@Query("update User u set u.firstName=:firstName where u.id=:id")
	public int updateUser(String firstName, long id);
	
	
	@Modifying
	@Query("delete from User u where u.id=id")
	public int deleteUser( long id);

}
