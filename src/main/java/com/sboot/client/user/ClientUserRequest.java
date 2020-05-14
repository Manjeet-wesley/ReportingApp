package com.sboot.client.user;

public class ClientUserRequest {
	
	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ClinetUserRequest [username=" + username + ", password=" + password + "]";
	}
	
	
	 

}
