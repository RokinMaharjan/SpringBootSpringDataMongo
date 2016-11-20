package com.rokin.springmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rokin.springmongo.entity.User;


public interface UserRepository extends MongoRepository<User, String>{
	public List<User> findByName(String name);
	public User findById(String id);
	public User findByIdAndName(String id, String name);
}
