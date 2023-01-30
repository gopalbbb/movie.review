package com.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movies.services.UserService;

@Controller
@RequestMapping("/movies")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/adduser")
	public String addUser() {
		return "addUser";}
	
	@PostMapping("/addUser")
	
	public String adduser(@RequestParam(value="user_name") String user_name,@RequestParam(value="address") String address,@RequestParam
			(value="contact_number") String contact_number) {
		userService.addUser(user_name, address, contact_number);
		return "completed";
	}

}
