package com.movies.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.movies.services.UserDetailsInfoServiceImp;

@Configuration
@EnableWebSecurity
//when we create enablemethodsecurity we can give access for specific person like admin or user 
// it this scenario  we have method with userDetailsService now some access give for admin some for user
// just go in controller  and type @PreAuthorize("hasAuthority('ROLE_ADMIN')") or user 
@EnableMethodSecurity 
public class SecurityConfig {
	@Bean
	public SecurityFilterChain configureFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		
		.authorizeHttpRequests()
		.requestMatchers("/user", "/movies","/Rest**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();

		
		return httpSecurity.build();
		
		
		
		/*//use following code if you want hardcoded in here for spcific funcation for user admin
		.authorizeHttpRequests()
		// this  permit all give access for all with out athcentaction any password username
		.requestMatchers("/movies/login").permitAll()
		//anyRequest()
		//if you want some authorige for some endpoind then need to active following thin
		// but if we define authorizeHttprequest , ... like that its need to user name and password 
		.and()
		.authorizeHttpRequests().requestMatchers("/movies/adduser","/movies/create")
		.authenticated()
		.and()
		.formLogin();
		//httpBasic()
		// loginPage("..../....."); html page ( have to read formlogin and httpBasic
		return httpSecurity.build();*/
		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getUsers() {
		/*
		 * UserDetails user = User.withUsername("user")
		 * .password(getPasswordEncoder().encode("user")) .roles("USER") .build();
		 * 
		 * 
		 * UserDetails admin = User.withUsername("admin")
		 * .password(getPasswordEncoder().encode("admin"))
		 * .roles("USER","ADMIN").build(); return new InMemoryUserDetailsManager(user,
		 * admin);
		 *
		 * 
		 */

		UserDetailsService service = new UserDetailsInfoServiceImp();
		return service;

	}

}
