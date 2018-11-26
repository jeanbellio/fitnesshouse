package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.User;
import com.fitnesshouse.api.repositories.UserRepository;
import com.fitnesshouse.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return this.userRepository.findAll(); 
	}

	@Override
	public User findById(String id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public User create(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void delete(String id) {
		this.userRepository.delete(id);
	}

	@Override
	public List<User> findByNameAndType(String name, String type) {
		return this.userRepository.findByNameAndType(name, type);
	}

	@Override
	public User login(User user) {
		return this.userRepository.login(user.getEmail(), user.getPassword());
	}
	
	@Override
	public User findByEmail(User user) {
		return this.userRepository.findByEmail(user.getEmail());
	}
}
