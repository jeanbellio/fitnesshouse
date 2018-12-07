package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.User;

public interface UserService {
	List<User> findAll();
	
	User findById(String id);
	
	User create(User user);
	
	User update(User user);
	
	void delete(String id);
	
	List<User> findByNameAndType(String name, String type);
	
	User login(User user);
	
	User findByEmail(String email);
	
	List<User> findByType(String type);
	
	List<User> findFreeStudentsByName(String name);
	
}
