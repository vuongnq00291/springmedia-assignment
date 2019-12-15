package com.springmedia.config;

public class APIConfig {
	
	private String name;
	private String url;
	private String requestType;
	private String failureReturnType;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getFailureReturnType() {
		return failureReturnType;
	}
	public void setFailureReturnType(String failureReturnType) {
		this.failureReturnType = failureReturnType;
	}
	
	

}
