package com.springmedia.pojo;

public class Post {
	 private float userId;
	 private float id;
	 private String title;
	 private String body;

	 public float getUserId() {
	  return userId;
	 }

	 public float getId() {
	  return id;
	 }

	 public String getTitle() {
	  return title;
	 }

	 public String getBody() {
	  return body;
	 }

	 public void setUserId(float userId) {
	  this.userId = userId;
	 }

	 public void setId(float id) {
	  this.id = id;
	 }

	 public void setTitle(String title) {
	  this.title = title;
	 }

	 public void setBody(String body) {
	  this.body = body;
	 }
	}