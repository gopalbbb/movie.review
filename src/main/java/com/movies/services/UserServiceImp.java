package com.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.Userdao;
import com.movies.entity.Movies;
import com.movies.entity.User;
@Service
public class UserServiceImp implements UserService {
@Autowired
	Userdao userdao;
	@Override
	public void addUser(String user_name, String address, String contact_number) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(user_name);
		user.setAddress(address);
		user.setContactNumuber(contact_number);
		userdao.save(user);
	}
	
	
	
	@Override
	public List<User> viewAlluser() {
		List<User> users=userdao.findAll();
		return users;
	}
	
	
		
	}

	

