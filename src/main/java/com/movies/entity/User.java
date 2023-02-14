package com.movies.entity;


import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table

@NamedQueries({
	@NamedQuery(name = "User.findByUsernameAndOTP", 
			query = "SELECT u FROM User u WHERE u.userName = ?1 and u.generatedOtpCode= ?2"),
	@NamedQuery(name = "User.findByUsername", 
	query = "SELECT u FROM User u WHERE u.userName = ?1 "),
	@NamedQuery(name = "User.findByEmail", 
	query = "SELECT u FROM User u WHERE u.email = ?1 "),
	@NamedQuery(name = "User.findByUsernameOrEmail", 
	query = "SELECT u FROM User u WHERE u.userName = ?1 Or u.email= ?1"),
	
		
})

public class User {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String address;
	private String password;
	private String role;
	private String contactNumuber;
	private String email;
	private Integer generatedOtpCode;
	private Integer validatedOtp;
	
	//cascade have many option we can use different with situation ,detach, merge, remove
	@OneToMany(cascade=CascadeType.ALL,targetEntity=MovieReview.class,mappedBy="user")
	List<MovieReview>reviews;

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

	public List<MovieReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<MovieReview> reviews) {
		this.reviews = reviews;
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


	}
	
	
	
	
	
	
	


