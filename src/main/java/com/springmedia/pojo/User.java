package com.springmedia.pojo;

import java.util.List;

public class User {
	 private float id;
	 private String name;
	 private String username;
	 private String email;
	 private Address AddressObject;
	 private String phone;
	 private String website;
	 private Company CompanyObject;
	 private List<Post> post;


	 // Getter Methods 

	 public float getId() {
	  return id;
	 }

	 public String getName() {
	  return name;
	 }

	 public String getUsername() {
	  return username;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public Address getAddress() {
	  return AddressObject;
	 }

	 public String getPhone() {
	  return phone;
	 }

	 public String getWebsite() {
	  return website;
	 }

	 public Company getCompany() {
	  return CompanyObject;
	 }

	 // Setter Methods 

	 public void setId(float id) {
	  this.id = id;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setUsername(String username) {
	  this.username = username;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setAddress(Address addressObject) {
	  this.AddressObject = addressObject;
	 }

	 public void setPhone(String phone) {
	  this.phone = phone;
	 }

	 public void setWebsite(String website) {
	  this.website = website;
	 }

	 public void setCompany(Company companyObject) {
	  this.CompanyObject = companyObject;
	 }

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	}
	
	