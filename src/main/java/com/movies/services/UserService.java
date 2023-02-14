package com.movies.services;

import java.util.List;

import com.movies.dto.UserDto;
import com.movies.entity.User;
import com.movies.exception.OtpNotFoundExcption;

public interface UserService {
	public void addUser(String user_name,String address,String contact_number,String password,String email,Integer generated_Otp_Code,Integer validated_Otp,String role);
	
	public List <User> viewAlluser();
	
	User getByUsernameAndPassword(String username, Integer password);
	
	User verifyOtp(UserDto userDto) throws OtpNotFoundExcption;

}
