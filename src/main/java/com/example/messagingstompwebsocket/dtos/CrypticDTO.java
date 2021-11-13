package com.example.messagingstompwebsocket.dtos;

public class CrypticDTO {
	private String token;
	private CrypticUser user;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public CrypticUser getUser() {
		return user;
	}
	public void setUser(CrypticUser user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CrypticDTO [token=" + token + ", user=" + user + "]";
	}
	
	
	
}
