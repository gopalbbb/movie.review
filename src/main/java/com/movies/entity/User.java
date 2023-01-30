package com.movies.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String address;
	private String contactNumuber;
	
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
	
	
	
	

}
