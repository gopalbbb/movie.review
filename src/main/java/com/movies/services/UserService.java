package com.movies.services;

import java.util.List;


import com.movies.entity.User;

public interface UserService {
	public void addUser(String user_name,String address,String contact_number);
	
	public List <User> viewAlluser();

}
