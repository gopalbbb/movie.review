package com.movies.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.movies.dto.UserDto;
import com.movies.entity.User;
import com.movies.exception.OtpNotFoundExcption;
import com.movies.services.MailService;
import com.movies.services.OtCode;

import com.movies.services.UserService;


import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/user")


public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	@Autowired
	OtCode otCode;

	@GetMapping("/login")
	@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
	public String login() {
		return "home";
	}
	
	
	@GetMapping("/adduser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String addUser() {
		return "addUser";}
	
	@PostMapping("/addUser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	
	public String adduser(@RequestParam(value="user_name") String user_name,@RequestParam(value="address") String address,@RequestParam
			(value="contact_number") String contact_number,@RequestParam(value="password") String password,@RequestParam(value="email") String email,
			@RequestParam(value="generated_otp_code",required = false) Integer generated_otp_code,
			@RequestParam(value="validated_otp",required = false) Integer validated_otp,@RequestParam(value="role") String role) throws MessagingException {
		
		userService.addUser(user_name, address, contact_number,password,email,generated_otp_code,validated_otp,role);
		
	
		return "completed";
	}
	
	@GetMapping("/otp/verify")
	public String verifyOtp(Model model) {
	
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
	
	
		return "movies/verify-otp";
		
	}
	
	@PostMapping("/otp/verify")
	public String verifyOtp(Model model, @ModelAttribute UserDto userDTO) throws OtpNotFoundExcption {
		
		User user = userService.verifyOtp(userDTO);
		
		return "redirect:/user/";
		
	}
	
	
}
