package com.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.movies.dao.Userdao;
import com.movies.entity.User;
import com.movies.security.UserDetailsInfo;

// this class created for security config spring security have already
//UserDetails Interface and userdetailsService just we implement here ..
public class UserDetailsInfoServiceImp implements UserDetailsService {

	@Autowired
	Userdao userdao;
	/*
	 * @Override public UserDetails loadUserByUsername(String email) throws
	 * UsernameNotFoundException { User user=userdao.findByEmail(email);
	 * if(user==null) { throw new UsernameNotFoundException(email); }
	 * 
	 * UserDetailsInfo userDetailsInfo=new UserDetailsInfo(user); return
	 * userDetailsInfo; }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// User user=userdao.findByEmail(username);
		//User user = userdao.findByUsername(username);
		
		User user=userdao.findByUsernameOrEmail(username);
		System.out.println(user);
		if(user==null) { throw new UsernameNotFoundException(username); }
		  
		  UserDetailsInfo userDetailsInfo=new UserDetailsInfo(user); 
		  return userDetailsInfo;
		
	}

}
