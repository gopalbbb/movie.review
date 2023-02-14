package com.movies.dto;

public class UserDto {
	private Integer userId;
	private String userName;
	private String address;
	private String password;
	private String role;
	private String contactNumuber;
	private String email;
	private Integer generatedOtpCode;
	private Integer validatedOtp;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContactNumuber() {
		return contactNumuber;
	}
	public void setContactNumuber(String contactNumuber) {
		this.contactNumuber = contactNumuber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGeneratedOtpCode() {
		return generatedOtpCode;
	}
	public void setGeneratedOtpCode(Integer generatedOtpCode) {
		this.generatedOtpCode = generatedOtpCode;
	}
	public Integer getValidatedOtp() {
		return validatedOtp;
	}
	public void setValidatedOtp(Integer validatedOtp) {
		this.validatedOtp = validatedOtp;
	}

	
	
	
	
}
