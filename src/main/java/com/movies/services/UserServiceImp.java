package com.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movies.dao.Userdao;
import com.movies.dto.UserDto;
import com.movies.entity.Movies;
import com.movies.entity.User;
import com.movies.exception.OtpNotFoundExcption;
@Service
public class UserServiceImp implements UserService {
@Autowired
	Userdao userdao;


	
	
	
	
	@Override
	public List<User> viewAlluser() {
		List<User> users=userdao.findAll();
		return users;
	}

@Autowired
OtCode otCode;
@Autowired
MailService mailService;
@Autowired
PasswordEncoder passwordEncoder;

	@Override
	public void addUser(String user_name, String address, String contact_number,String password,
			String email, Integer generated_otp_code,
			Integer validated_otp,String role) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(user_name);
		user.setAddress(address);
		user.setContactNumuber(contact_number);
		user.setPassword(passwordEncoder.encode(password));
		user.setEmail(email);
		user.setGeneratedOtpCode(otCode.generateOTP(user_name));
		user.setValidatedOtp(0);
		user.setRole(role);
		userdao.save(user);
		mailService.sendOtp(email, user_name,user.getGeneratedOtpCode());
	}

	@Override
	public User verifyOtp(UserDto userDto) throws OtpNotFoundExcption {
		User user =getByUsernameAndPassword(userDto.getUserName(),userDto.getGeneratedOtpCode());
		if(user==null) {
			throw new OtpNotFoundExcption("otp is not verified");
		}else {
			user.setValidatedOtp(null);
			userdao.save(user);
		}
		
		
		return user;
	}

	@Override
	public User getByUsernameAndPassword(String username, Integer password) {
		
		return userdao.findByUsernameAndOTP(username, password);
	}



	
		
	}

	

