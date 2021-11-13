package com.example.messagingstompwebsocket.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.messagingstompwebsocket.dtos.CrypticUser;

@Component
public class LoggedInUsersMap {
	
	Map<String, CrypticUser> users;
	
	public LoggedInUsersMap() {
		users = new HashMap<>();
	}

	public Map<String, CrypticUser> getUsers() {
		return users;
	}
	
	
}
