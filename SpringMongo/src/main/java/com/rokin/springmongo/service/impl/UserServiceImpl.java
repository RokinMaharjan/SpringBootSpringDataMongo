package com.rokin.springmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rokin.springmongo.entity.User;
import com.rokin.springmongo.repository.UserRepository;
import com.rokin.springmongo.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers(String id) {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public ResponseEntity<String> postMethod(User user) {
		if(user.getName()==null)
		{
			//Make Error Object and return object for formatted error message
			String json = "{\"type\":\"Exception\", \"message\":\"Cannot enter null value\"}";
			
			return new ResponseEntity<String>(json,HttpStatus.BAD_REQUEST);
		}
		else
		{
			userRepository.save(user);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> deleteMethod(String id) {
		if(id==null)
		{
			//Make Error Object and return object for formatted error message
			String json = "{\"type\":\"Exception\", \"message\":\"Cannot enter null value\"}";
			return new ResponseEntity<String>(json,HttpStatus.BAD_REQUEST);
		}
		else
		{
			userRepository.delete(id);
			return new ResponseEntity<String>("Saved",HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> putMethod(User user) {
		if(user.getName()==null)
		{
			
			//Make Error Object and return object for formatted error message
			String json = "{\"type\":\"Exception\", \"message\":\"Cannot enter null value\"}";
			return new ResponseEntity<String>(json,HttpStatus.BAD_REQUEST);
		}
		else
		{
			userRepository.save(user);
			return new ResponseEntity<String>("Saved",HttpStatus.OK);
		}
	}
	
	
}
