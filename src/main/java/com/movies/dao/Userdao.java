package com.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.User;
@Repository
public interface Userdao extends JpaRepository<User,Integer>{
	
	public User findByUsernameAndOTP(String username,Integer generatedOtpCode);

	public User findByUsername(String username);
	public User findByEmail(String email);
	public User findByUsernameOrEmail(String username);

}
