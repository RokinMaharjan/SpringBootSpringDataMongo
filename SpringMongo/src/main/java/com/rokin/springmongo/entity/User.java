package com.rokin.springmongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	String id, name, company;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
