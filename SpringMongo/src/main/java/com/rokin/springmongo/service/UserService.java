package com.rokin.springmongo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rokin.springmongo.entity.User;

public interface UserService {
	List<User> getAllUsers(String id);
	List<User> getUserByName(String name);
	ResponseEntity<String> postMethod(User user);
	ResponseEntity<String> deleteMethod(String id);
	ResponseEntity<String> putMethod(User user);
}
