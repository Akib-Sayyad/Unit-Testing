package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User addUser(User user) {
		return repository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = repository.findAll();
		System.out.println("Getting Data of Users : " + users);
		return users;
	}
	
	public List<User> getUsersbyAddress(String address){
		return repository.findByAddress(address);
	}
	
	public void deleteUser(User user) {
		repository.delete(user);
	}
}
