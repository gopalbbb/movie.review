package com.movies.security;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.movies.entity.User;

/*// this class we created for security propose here UserDetails is interface
class for security confuige  we only implement method here with fatch data from
database few method is in userdatails we can implement with database
entity where we can fetch data and give authority for access our app,.*/
// just create one class add interface userdetails springsecurity
// filter  relative this in one word intersepter 
// serilizion relative in one word marker interface.

public class UserDetailsInfo implements UserDetails {

	private static final long serialVersionUID = -205307343605970436L;

	private User user;

	public UserDetailsInfo(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//List<GrantedAuthority> authorities=new ArrayList<>();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		String[] roles = user.getRole().split(",");
		for(String role: roles) {
			authorities.add(new SimpleGrantedAuthority(role));
	}
		return authorities;
		
		
		//using lambda expression
		/*
		 * List<GrantedAuthority> authorities=
		 * Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).
		 * collect(Collectors.toList()); System.out.println(authorities); return
		 * authorities;
		 */
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	
	@Override
	public String getUsername() {
	
		return user.getUserName();
	}
	/*
	 * @Override
	 * 
	 * public String getUsername() { // TODO Auto-generated method stub return
	 * user.getEmail(); }
	 * 
	 */

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
