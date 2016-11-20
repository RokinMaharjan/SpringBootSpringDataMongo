package com.rokin.springmongo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rokin.springmongo.entity.User;
import com.rokin.springmongo.service.UserService;



@RestController
@RequestMapping(value="/api/v1/users")
public class MongoController {
	
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/", method=RequestMethod.GET)     // produces="application/json"
	public List<User> getAllUsers(@RequestParam(value = "id", required = false) String id)
	{		
		return userService.getAllUsers(id);
	}

	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public List<User> getUserByName(@PathVariable("name") String name)
	{
		return userService.getUserByName(name);
	}

	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> postMethod(@RequestBody User user)
	{
		return userService.postMethod(user);
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteMethod(@PathVariable String id)
	{
		return userService.deleteMethod(id);
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<String> putMethod(@RequestBody User user)
	{
		return userService.putMethod(user);
	}
	
		//FOR  COMPULSORY PATH VARIABLE "name" AND OPTIONAL REQUEST PARAM "id"
//===============================================================================
//	@RequestMapping(value="/{name}", method=RequestMethod.GET)
//	public User getUserById(@PathVariable("name") String name, @RequestParam(value = "id", required = false) String id)
//	{
//		return userRepository.findByIdAndName(id, name);
//	}
	
}
